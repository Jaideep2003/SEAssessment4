import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Post {
    private int postID;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String postType;
    private String postEmergencyStatus;
    private ArrayList<String> postComments = new ArrayList<>();

    // Constructor
    public Post() {}

    // Getters and Setters
    public int getPostID() { return postID; }
    public void setPostID(int postID) { this.postID = postID; }

    public String getPostTitle() { return postTitle; }
    public void setPostTitle(String postTitle) { this.postTitle = postTitle; }

    public String getPostBody() { return postBody; }
    public void setPostBody(String postBody) { this.postBody = postBody; }

    public String[] getPostTags() { return postTags; }
    public void setPostTags(String[] postTags) { this.postTags = postTags; }

    public String getPostType() { return postType; }
    public void setPostType(String postType) { this.postType = postType; }

    public String getPostEmergencyStatus() { return postEmergencyStatus; }
    public void setPostEmergencyStatus(String postEmergencyStatus) { this.postEmergencyStatus = postEmergencyStatus; }

    public ArrayList<String> getPostComments() { return postComments; }
    public void setPostComments(ArrayList<String> postComments) { this.postComments = postComments; }

    // toString method to format post details for writing to file
    @Override
    public String toString() {
        return "PostID: " + postID + "\nTitle: " + postTitle + "\nBody: " + postBody + "\nTags: " + String.join(", ", postTags) + "\nType: " + postType + "\nEmergency: " + postEmergencyStatus + "\nComments: " + String.join("; ", postComments);
    }

    // Method to add a post
    public boolean addPost() {
        if (isValidPost()) {
            try (FileWriter writer = new FileWriter("post.txt", true)) {
                writer.write(this.toString() + "\n");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    // Method to validate a post
    private boolean isValidPost() {
        // Condition 1: Title validation
        if (postTitle == null || postTitle.length() < 10 || postTitle.length() > 250 || !Pattern.matches("^[^\\d\\W]{5}.*", postTitle)) {
            return false;
        }
        // Condition 2: Body length validation
        if (postBody == null || postBody.length() < 250) {
            return false;
        }
        // Condition 3: Tags validation
        if (postTags == null || postTags.length < 2 || postTags.length > 5) {
            return false;
        }
        for (String tag : postTags) {
            if (tag.length() < 2 || tag.length() > 10 || !tag.equals(tag.toLowerCase())) {
                return false;
            }
        }
        // Condition 4: Type validation
        if (!Arrays.asList("Very Difficult", "Difficult", "Easy").contains(postType)) {
            return false;
        }
        if (postType.equals("Easy") && postTags.length > 3) {
            return false;
        }
        if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postBody.length() < 300) {
            return false;
        }
        // Condition 5: Emergency status validation
        if (!Arrays.asList("Immediately Needed", "Highly Needed", "Ordinary").contains(postEmergencyStatus)) {
            return false;
        }
        if (postType.equals("Easy") && (postEmergencyStatus.equals("Immediately Needed") || postEmergencyStatus.equals("Highly Needed"))) {
            return false;
        }
        if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postEmergencyStatus.equals("Ordinary")) {
            return false;
        }
        return true;
    }

    // Method to add a comment
    public boolean addComment(String comment) {
        if (isValidComment(comment)) {
            try (FileWriter writer = new FileWriter("comment.txt", true)) {
                writer.write(comment + "\n");
                postComments.add(comment);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    // Method to validate a comment
    private boolean isValidComment(String comment) {
        // Condition 1: Comment length and first character validation
        String[] words = comment.split("\\s+");
        if (words.length < 4 || words.length > 10 || !Character.isUpperCase(words[0].charAt(0))) {
            return false;
        }
        // Condition 2: Number of comments validation
        if ((postType.equals("Easy") || postEmergencyStatus.equals("Ordinary")) && postComments.size() >= 3) {
            return false;
        }
        if (postComments.size() >= 5) {
            return false;
        }
        return true;
    }
}




