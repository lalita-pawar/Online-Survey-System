public class UserAuthentication {
    public boolean authenticateUser(String username, String password) {
        // Logic to check username and password in the database
        return isValidCredentials(username, password);
    }

    private boolean isValidCredentials(String username, String password) {
        // Dummy method for demonstration
        return "admin".equals(username) && "password".equals(password);
    }
}
