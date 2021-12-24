package workshop.binarychop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BinaryChopController.class)
public class ControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void findIndex_ShouldReturnNullWhenListIsEmpty() throws Exception {
        MockHttpServletRequestBuilder request = get("/binarychop?id=1&values=");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("List Empty"));

    }

    @Test
    public void _ShouldReturnNumberNotFoundIfNumberNotInList() throws Exception {
        MockHttpServletRequestBuilder request = get("/binarychop?id=5&values=3,4,7");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Number not found"));
    }

    @Test
    public void findIndex_ShouldReturnIndex0OfAOneMemberList() throws Exception {
        MockHttpServletRequestBuilder request = get("/binarychop?id=1&values=1");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Number found at index: 0"));
    }


}
