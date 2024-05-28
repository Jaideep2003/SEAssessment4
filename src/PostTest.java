import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PostTest {
    @Test
    public void testAddPost_Valid() {
        Post post = new Post();
        post.setPostID(1);
        post.setPostTitle("Valid Title for Post");
        post.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post.setPostTags(new String[]{"tag1", "tag2"});
        post.setPostType("Difficult");
        post.setPostEmergencyStatus("Highly Needed");
        assertTrue(post.addPost());
    }

    @Test
    public void testAddPost_TitleTooShort() {
        Post post = new Post();
        post.setPostID(1);
        post.setPostTitle("Short");
        post.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post.setPostTags(new String[]{"tag1", "tag2"});
        post.setPostType("Difficult");
        post.setPostEmergencyStatus("Highly Needed");
        assertFalse(post.addPost());
    }

    @Test
    public void testAddComment_Valid() {
        Post post = new Post();
        post.setPostID(1);
        post.setPostTitle("Valid Title for Post");
        post.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post.setPostTags(new String[]{"tag1", "tag2"});
        post.setPostType("Difficult");
        post.setPostEmergencyStatus("Highly Needed");
        post.addPost(); // Ensure the post is valid before adding a comment
        assertTrue(post.addComment("This is a valid comment."));
    }

    @Test
    public void testAddComment_TooShort() {
        Post post = new Post();
        post.setPostID(1);
        post.setPostTitle("Valid Title for Post");
        post.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post.setPostTags(new String[]{"tag1", "tag2"});
        post.setPostType("Difficult");
        post.setPostEmergencyStatus("Highly Needed");
        post.addPost(); // Ensure the post is valid before adding a comment
        assertFalse(post.addComment("Too short"));
    }

    // Add more tests for other conditions...
}

