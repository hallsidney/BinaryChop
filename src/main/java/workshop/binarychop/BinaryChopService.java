package workshop.binarychop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryChopService {
    List<Integer> values;
    Integer number;
    public void setValues(List<String> values) {
        this.values=values
                .stream()
                .map(s-> Integer.parseInt(s))
                .sorted()
                .collect(Collectors.toList());

    }

    public void setNumber(String id) {
        this.number = Integer.parseInt(id);
    }

    public int findIndexWithArrayListBuiltInMethod()
    {
        if(this.values.size() == 0)
            return -2;
        if(!this.values.contains(this.number))
            return -1;
        else
            return this.values.indexOf(this.number);
    }

    public int findIndexWithCustomBuiltMethod(){
        var indexTracker = 0;
        var tempList = this.values;
        int length = tempList.size();
        if (length == 0) return -2;
        while(tempList.size() != 1){
            if(tempList.get(length/2 - 1) == this.number){
                indexTracker += length/2 - 1;
                break;
            }
            else if (tempList.get(length/2 - 1) < this.number) {
                tempList = tempList.subList(length/2, length);
                indexTracker += length/2;

            } else {
                tempList = this.values.subList(0, length / 2);
            }

            length = tempList.size();
            if(length == 1 && tempList.get(0) != this.number){
                indexTracker = -1;
                break;
            }
        }
        return indexTracker;
    }
}
