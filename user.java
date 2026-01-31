public class User {
    private String name;
    private String email;
    private String role;

    // Constructor
    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user);
    }

    public void removeUser(User user) {
        users.remove(user);
        System.out.println("User removed: " + user);
    }

    public List<User> listUsers() {
        return users;
    }
}
public enum UserRole {
    ADMIN,
    USER,
    GUEST
}
public class MainApp {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        // Creating users
        User user1 = new User("Alice", "alice@example.com", UserRole.ADMIN.name());
        User user2 = new User("Bob", "bob@example.com", UserRole.USER.name());

        // Adding users
        userManager.addUser(user1);
        userManager.addUser(user2);

        // Listing users
        System.out.println("All users:");
        for (User user : userManager.listUsers()) {
            System.out.println(user);
        }

        // Removing a user
        userManager.removeUser(user1);

        // Listing users after removal
        System.out.println("Users after removal:");
        for (User user : userManager.listUsers()) {
            System.out.println(user);
        }
    }
}
public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (user == null || user.getName() == null || user.getEmail() == null || user.getRole() == null) {
            System.out.println("Invalid user. Cannot add.");
            return;
        }
        users.add(user);
        System.out.println("User added: " + user);
    }

    public void removeUser(User user) {
        users.remove(user);
        System.out.println("User removed: " + user);
    }

    public List<User> listUsers() {
        return users;
    }
}
public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (user == null || user.getName() == null || user.getEmail() == null || user.getRole() == null) {
            System.out.println("Invalid user. Cannot add.");
            return;
        }
        users.add(user);
        System.out.println("User added: " + user);
    }

    public void removeUser(User user) {
        users.remove(user);
        System.out.println("User removed: " + user);
    }

    public List<User> listUsers() {
        return users;
    }

    public List<User> searchByRole(UserRole role) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getRole().equals(role.name())) {
                result.add(user);
            }
        }
        return result;
    }
}
import java.util.Scanner;

public class UserManagerCLI {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("User Manager CLI");
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. List Users");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter role (ADMIN, USER, GUEST): ");
                String role = scanner.nextLine();

                User user = new User(name, email, role);
                userManager.addUser(user);
            } else if (option == 2) {
                System.out.print("Enter name of user to remove: ");
                String name = scanner.nextLine();
                User user = userManager.listUsers().stream()
                        .filter(u -> u.getName().equals(name))
                        .findFirst()
                        .orElse(null);
                if (user != null) {
                    userManager.removeUser(user);
                } else {
                    System.out.println("User not found.");
                }
            } else if (option == 3) {
                System.out.println("Listing all users:");
                for (User user : userManager.listUsers()) {
                    System.out.println(user);
                }
            } else if (option == 4) {
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

import java.util.regex.Pattern;

public class UserValidator {

    // Validate email format
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Validate role (assuming only admin and user are allowed)
    public static boolean isValidRole(String role) {
        return role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("user");
    }
}

public class User {
    private String username;
    private String email;
    private String role;
    private String address;
    private String phoneNumber;

    // Constructor
    public User(String username, String email, String role, String address, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters for address and phone number
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Other existing getters and setters...
}
public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    // Other methods...

    public List<User> searchUsers(String searchQuery) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getUsername().contains(searchQuery) || user.getEmail().contains(searchQuery)) {
                result.add(user);
            }
        }
        return result;
    }
}

public class User {
    private String username;
    private String email;
    private String role;
    private int failedLoginAttempts; // Counter for failed login attempts
    private boolean isLocked; // Indicates if the account is locked

    // Constructor
    public User(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.failedLoginAttempts = 0;
        this.isLocked = false;
    }

    // Getters and Setters
    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void incrementFailedLoginAttempts() {
        this.failedLoginAttempts++;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void lockAccount() {
        this.isLocked = true;
    }

    public void unlockAccount() {
        this.isLocked = false;
        this.failedLoginAttempts = 0;
    }

    // Other existing methods...
}

public class AccessControl {

    // Check if the user has access to a specific resource based on their role
    public static boolean hasAccess(User user, String resource) {
        if ("admin".equals(user.getRole())) {
            return true; // Admin has access to all resources
        }

        // Example: only "user" role can access "viewProfile"
        if ("user".equals(user.getRole()) && "viewProfile".equals(resource)) {
            return true;
        }

        return false;
    }
}
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserPasswordManager {

    // Hash password using SHA-256
    public static String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error hashing password: " + e.getMessage());
            return null;
        }
    }
}
import java.util.Date;

public class UserActivityLog {

    public static void logActivity(User user, String activity) {
        Date date = new Date();
        System.out.println("Activity Log: User: " + user.getUsername() + ", Activity: " + activity + ", Date: " + date);
    }
}
public class EmailNotification {

    public static void sendLockNotification(User user) {
        System.out.println("Sending email to " + user.getEmail() + ": Your account has been locked due to multiple failed login attempts.");
    }

    public static void sendUnlockNotification(User user) {
        System.out.println("Sending email to " + user.getEmail() + ": Your account has been unlocked. You can now log in.");
    }
}
import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private Map<String, User> activeSessions;

    public SessionManager() {
        activeSessions = new HashMap<>();
    }

    // Start a session for a user
    public void startSession(User user) {
        activeSessions.put(user.getEmail(), user);
        System.out.println("Session started for user: " + user.getUsername());
    }

    // End a session for a user
    public void endSession(User user) {
        activeSessions.remove(user.getEmail());
        System.out.println("Session ended for user: " + user.getUsername());
    }

    // Check if a user is logged in
    public boolean isLoggedIn(User user) {
        return activeSessions.containsKey(user.getEmail());
    }
}

public class User {
    private String username;
    private String email;
    private String role;
    private String profilePictureUrl; // Store profile picture URL

    // Constructor
    public User(String username, String email, String role, String profilePictureUrl) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.profilePictureUrl = profilePictureUrl;
    }

    // Getter and Setter for profilePictureUrl
    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}

import java.util.UUID;

public class PasswordResetManager {
    private Map<String, String> resetTokens; // Map of tokens to emails

    public PasswordResetManager() {
        resetTokens = new HashMap<>();
    }

    // Generate a reset token for a user
    public String generateResetToken(User user) {
        String token = UUID.randomUUID().toString();
        resetTokens.put(token, user.getEmail());
        System.out.println("Reset token generated for user: " + user.getUsername());
        return token;
    }

    // Validate the reset token
    public boolean validateResetToken(String token) {
        return resetTokens.containsKey(token);
    }

    // Reset the user's password
    public void resetPassword(String token, String newPassword) {
        if (validateResetToken(token)) {
            String email = resetTokens.get(token);
            // Retrieve user by email and reset password (simulated here)
            System.out.println("Password reset successful for user with email: " + email);
        } else {
            System.out.println("Invalid reset token.");
        }
    }
}
public class EmailVerificationManager {
    private Map<String, Boolean> emailVerifications;

    public EmailVerificationManager() {
        emailVerifications = new HashMap<>();
    }

    // Send a verification email (simulated here)
    public void sendVerificationEmail(User user) {
        String verificationToken = UUID.randomUUID().toString();
        emailVerifications.put(user.getEmail(), false); // Email initially not verified
        System.out.println("Verification email sent to: " + user.getEmail() + " with token: " + verificationToken);
    }

    // Verify the user's email using the verification token
    public void verifyEmail(String email, String token) {
        if (emailVerifications.containsKey(email)) {
            emailVerifications.put(email, true);
            System.out.println("Email verified for user: " + email);
        } else {
            System.out.println("Invalid email or verification token.");
        }
    }
}
public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    // Other methods...

    // Search users by role
    public List<User> searchUsersByRole(String role) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getRole().equalsIgnoreCase(role)) {
                result.add(user);
            }
        }
        return result;
    }
}
import java.util.Date;

public class UserActivityLog {

    public static void logActivity(User user, String activity) {
        Date date = new Date();
        System.out.println("Activity Log: User: " + user.getUsername() + ", Activity: " + activity + ", Date: " + date);
    }
}
public class MultiFactorAuthentication {

    // Simulate sending an MFA code to the user via email
    public static String sendMfaCode(User user) {
        String mfaCode = UUID.randomUUID().toString().substring(0, 6); // Generate a 6-digit code
        System.out.println("MFA Code sent to " + user.getEmail() + ": " + mfaCode);
        return mfaCode;
    }

    // Validate the entered MFA code
    public static boolean validateMfaCode(User user, String enteredCode, String correctCode) {
        if (enteredCode.equals(correctCode)) {
            System.out.println("MFA validated for user: " + user.getUsername());
            return true;
        } else {
            System.out.println("Invalid MFA code for user: " + user.getUsername());
            return false;
        }
    }
}
public class LoginHistoryManager {
    private Map<String, List<String>> userLoginHistory;

    public LoginHistoryManager() {
        userLoginHistory = new HashMap<>();
    }

    // Log a user's login attempt
    public void logLogin(User user, String ipAddress) {
        String timestamp = new Date().toString();
        String loginAttempt = "Login attempt at " + timestamp + " from IP: " + ipAddress;

        userLoginHistory.putIfAbsent(user.getEmail(), new ArrayList<>());
        userLoginHistory.get(user.getEmail()).add(loginAttempt);

        System.out.println("Login history recorded for user: " + user.getUsername());
    }

    // View login history for a user
    public List<String> getLoginHistory(User user) {
        return userLoginHistory.getOrDefault(user.getEmail(), new ArrayList<>());
    }
}

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {

    private Map<String, String> notifications;

    public NotificationManager() {
        notifications = new HashMap<>();
    }

    // Send a notification to a user
    public void sendNotification(User user, String message) {
        notifications.put(user.getEmail(), message);
        System.out.println("Notification sent to " + user.getEmail() + ": " + message);
    }

    // View notifications for a user
    public String getNotifications(User user) {
        return notifications.getOrDefault(user.getEmail(), "No notifications.");
    }
}
public class SubscriptionManager {
    private Map<String, String> subscriptions; // Map of email to subscription type

    public SubscriptionManager() {
        subscriptions = new HashMap<>();
    }

    // Subscribe a user to a specific type of notification
    public void subscribeUser(User user, String subscriptionType) {
        subscriptions.put(user.getEmail(), subscriptionType);
        System.out.println("User " + user.getUsername() + " subscribed to " + subscriptionType + " notifications.");
    }

    // Get the subscription type for a user
    public String getSubscription(User user) {
        return subscriptions.getOrDefault(user.getEmail(), "No subscription.");
    }
}
public class RoleManager {

    // Assign a new role to a user
    public void assignRole(User user, String role) {
        user.setRole(role);
        System.out.println("Role " + role + " assigned to user: " + user.getUsername());
    }

    // Modify an existing role
    public void modifyRole(User user, String newRole) {
        user.setRole(newRole);
        System.out.println("Role changed to " + newRole + " for user: " + user.getUsername());
    }
}
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UserDataBackup {

    // Backup user data to a file
    public void backupUserData(User user) {
        try {
            String userData = "User Data: " + user.getUsername() + ", " + user.getEmail() + ", " + user.getRole();
            Path backupPath = Path.of("backups", user.getUsername() + "_backup.txt");
            Files.createDirectories(backupPath.getParent());
            Files.writeString(backupPath, userData);
            System.out.println("Backup successful for user: " + user.getUsername());
        } catch (IOException e) {
            System.out.println("Error while backing up user data: " + e.getMessage());
        }
    }

    // Restore user data from a backup file
    public void restoreUserData(User user) {
        Path backupPath = Path.of("backups", user.getUsername() + "_backup.txt");
        try {
            if (Files.exists(backupPath)) {
                String restoredData = Files.readString(backupPath);
                System.out.println("User data restored for: " + user.getUsername() + " | " + restoredData);
            } else {
                System.out.println("No backup found for user: " + user.getUsername());
            }
        } catch (IOException e) {
            System.out.println("Error while restoring user data: " + e.getMessage());
        }
    }
}
import java.io.File;
import java.io.IOException;

public class FileUploadManager {

    // Upload a file
    public void uploadFile(File file) {
        if (file.exists()) {
            System.out.println("Uploading file: " + file.getName());
        } else {
            System.out.println("File not found: " + file.getName());
        }
    }

    // Simulate saving the uploaded file (in reality, this could involve saving the file to cloud storage or local server)
    public void saveUploadedFile(File file) throws IOException {
        File destination = new File("uploads/" + file.getName());
        if (file.renameTo(destination)) {
            System.out.println("File uploaded successfully: " + file.getName());
        } else {
            System.out.println("Failed to upload file: " + file.getName());
        }
    }
}





















