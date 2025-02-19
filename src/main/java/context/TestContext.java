package context;

import lombok.Data;

@Data
public class TestContext {
    private String registeredEmail;
    private String registeredPassword = "Test123!";
    private String registeredName = "John Doe";
}