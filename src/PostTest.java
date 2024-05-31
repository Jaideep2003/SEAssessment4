import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PostTest {

    @Test
    public void testAddPost_Valid() {
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Valid Post Title Here");
        post1.setPostBody("This is a valid body with more than 300 characters. This body should meet the minimum character requirement for Difficult and Very Difficult posts. Adding a lot more text to ensure it exceeds the limit and covers all the necessary conditions for a valid post. More text, more text, more text, and even more text to finally reach well over 300 characters. This should now be sufficient.");
        post1.setPostTags(new String[]{"tag1", "tag2"});
        post1.setPostType("Difficult");
        post1.setPostEmergencyStatus("Highly Needed");

        Post post2 = new Post();
        post2.setPostID(2);
        post2.setPostTitle("Another Valid Title");
        post2.setPostBody("This is another valid body with more than 300 characters. Adding more text to ensure it exceeds the limit. Even more text to finally reach well over 300 characters. This should now be sufficient.");
        post2.setPostTags(new String[]{"tag3", "tag4"});
        post2.setPostType("Difficult");
        post2.setPostEmergencyStatus("Immediately Needed");

        assertTrue(post1.addPost());
        assertTrue(post2.addPost());
    }

    @Test
    public void testAddPost_InvalidTitle() {
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Short");
        post1.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post1.setPostTags(new String[]{"tag1", "tag2"});
        post1.setPostType("Difficult");
        post1.setPostEmergencyStatus("Highly Needed");

        Post post2 = new Post();
        post2.setPostID(2);
        post2.setPostTitle("Tiny");
        post2.setPostBody("This is another valid body with more than 250 characters. Adding some more text to ensure it exceeds the limit.");
        post2.setPostTags(new String[]{"tag3", "tag4"});
        post2.setPostType("Difficult");
        post2.setPostEmergencyStatus("Immediately Needed");

        assertFalse(post1.addPost());
        assertFalse(post2.addPost());
    }

    @Test
    public void testAddPost_InvalidBody() {
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Valid Post Title Here");
        post1.setPostBody("Short text");
        post1.setPostTags(new String[]{"tag1", "tag2"});
        post1.setPostType("Difficult");
        post1.setPostEmergencyStatus("Highly Needed");

        Post post2 = new Post();
        post2.setPostID(2);
        post2.setPostTitle("Another Valid Title");
        post2.setPostBody("Another short text");
        post2.setPostTags(new String[]{"tag3", "tag4"});
        post2.setPostType("Difficult");
        post2.setPostEmergencyStatus("Immediately Needed");

        assertFalse(post1.addPost());
        assertFalse(post2.addPost());
    }

    @Test
    public void testAddPost_InvalidTags() {
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Valid Post Title Here");
        post1.setPostBody("This is a valid body with more than 300 characters. This body should meet the minimum character requirement for Difficult and Very Difficult posts. Adding a lot more text to ensure it exceeds the limit and covers all the necessary conditions for a valid post. More text, more text, more text, and even more text to finally reach well over 300 characters. This should now be sufficient.");
        post1.setPostTags(new String[]{"Tag1", "tag2"});
        post1.setPostType("Difficult");
        post1.setPostEmergencyStatus("Highly Needed");

        Post post2 = new Post();
        post2.setPostID(2);
        post2.setPostTitle("Another Valid Title");
        post2.setPostBody("This is another valid body with more than 300 characters. Adding more text to ensure it exceeds the limit. Even more text to finally reach well over 300 characters. This should now be sufficient.");
        post2.setPostTags(new String[]{"tag3", "Tag4"});
        post2.setPostType("Difficult");
        post2.setPostEmergencyStatus("Immediately Needed");

        assertFalse(post1.addPost());
        assertFalse(post2.addPost());
    }

    @Test
    public void testAddPost_InvalidEmergencyStatus() {
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Valid Post Title Here");
        post1.setPostBody("This is a valid body with more than 300 characters. This body should meet the minimum character requirement for Difficult and Very Difficult posts. Adding a lot more text to ensure it exceeds the limit and covers all the necessary conditions for a valid post. More text, more text, more text, and even more text to finally reach well over 300 characters. This should now be sufficient.");
        post1.setPostTags(new String[]{"tag1", "tag2"});
        post1.setPostType("Easy");
        post1.setPostEmergencyStatus("Highly Needed");

        Post post2 = new Post();
        post2.setPostID(2);
        post2.setPostTitle("Another Valid Title");
        post2.setPostBody("This is another valid body with more than 300 characters. Adding more text to ensure it exceeds the limit. Even more text to finally reach well over 300 characters. This should now be sufficient.");
        post2.setPostTags(new String[]{"tag3", "tag4"});
        post2.setPostType("Easy");
        post2.setPostEmergencyStatus("Immediately Needed");

        assertFalse(post1.addPost());
        assertFalse(post2.addPost());
    }

    @Test
    public void testAddComment_Valid() {
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Valid Post Title Here");
        post1.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post1.setPostTags(new String[]{"tag1", "tag2"});
        post1.setPostType("Difficult");
        post1.setPostEmergencyStatus("Highly Needed");
        post1.addPost(); // Ensure the post is valid before adding a comment

        Post post2 = new Post();
        post2.setPostID(2);
        post2.setPostTitle("Another Valid Title");
        post2.setPostBody("This is another valid body with more than 250 characters. Adding some more text to ensure it exceeds the limit.");
        post2.setPostTags(new String[]{"tag3", "tag4"});
        post2.setPostType("Difficult");
        post2.setPostEmergencyStatus("Immediately Needed");
        post2.addPost(); // Ensure the post is valid before adding a comment

        assertTrue(post1.addComment("This is a valid comment."));
        assertTrue(post2.addComment("Another valid comment."));
    }

    @Test
    public void testAddComment_TooShort() {
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Valid Post Title Here");
        post1.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post1.setPostTags(new String[]{"tag1", "tag2"});
        post1.setPostType("Difficult");
        post1.setPostEmergencyStatus("Highly Needed");
        post1.addPost(); // Ensure the post is valid before adding a comment

        Post post2 = new Post();
        post2.setPostID(2);
        post2.setPostTitle("Another Valid Title");
        post2.setPostBody("This is another valid body with more than 250 characters. Adding some more text to ensure it exceeds the limit.");
        post2.setPostTags(new String[]{"tag3", "tag4"});
        post2.setPostType("Difficult");
        post2.setPostEmergencyStatus("Immediately Needed");
        post2.addPost(); // Ensure the post is valid before adding a comment

        assertFalse(post1.addComment("Too short"));
        assertFalse(post2.addComment("Short text"));
    }

    @Test
    public void testAddComment_TooLong() {
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Valid Post Title Here");
        post1.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post1.setPostTags(new String[]{"tag1", "tag2"});
        post1.setPostType("Difficult");
        post1.setPostEmergencyStatus("Highly Needed");
        post1.addPost(); // Ensure the post is valid before adding a comment

        Post post2 = new Post();
        post2.setPostID(2);
        post2.setPostTitle("Another Valid Title");
        post2.setPostBody("This is another valid body with more than 250 characters. Adding some more text to ensure it exceeds the limit.");
        post2.setPostTags(new String[]{"tag3", "tag4"});
        post2.setPostType("Difficult");
        post2.setPostEmergencyStatus("Immediately Needed");
        post2.addPost(); // Ensure the post is valid before adding a comment

        assertFalse(post1.addComment("This comment has way more than ten words which is not allowed."));
        assertFalse(post2.addComment("This is another comment that exceeds the word limit."));
    }

    @Test
    public void testAddComment_InvalidFirstCharacter() {
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Valid Post Title Here");
        post1.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post1.setPostTags(new String[]{"tag1", "tag2"});
        post1.setPostType("Difficult");
        post1.setPostEmergencyStatus("Highly Needed");
        post1.addPost(); // Ensure the post is valid before adding a comment

        Post post2 = new Post();
        post2.setPostID(2);
        post2.setPostTitle("Another Valid Title");
        post2.setPostBody("This is another valid body with more than 250 characters. Adding some more text to ensure it exceeds the limit.");
        post2.setPostTags(new String[]{"tag3", "tag4"});
        post2.setPostType("Difficult");
        post2.setPostEmergencyStatus("Immediately Needed");
        post2.addPost(); // Ensure the post is valid before adding a comment

        assertFalse(post1.addComment("this comment starts with lowercase."));
        assertFalse(post2.addComment("another invalid comment."));
    }

    @Test
    public void testAddComment_MaxCommentsReached() {
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Valid Post Title Here");
        post1.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post1.setPostTags(new String[]{"tag1", "tag2"});
        post1.setPostType("Difficult");
        post1.setPostEmergencyStatus("Highly Needed");
        post1.addPost(); // Ensure the post is valid before adding comments

        Post post2 = new Post();
        post2.setPostID(2);
        post2.setPostTitle("Another Valid Title");
        post2.setPostBody("This is another valid body with more than 250 characters. Adding some more text to ensure it exceeds the limit.");
        post2.setPostTags(new String[]{"tag3", "tag4"});
        post2.setPostType("Difficult");
        post2.setPostEmergencyStatus("Immediately Needed");
        post2.addPost(); // Ensure the post is valid before adding comments

        // Add 5 valid comments to post1
        for (int i = 0; i < 5; i++) {
            post1.addComment("This is comment number " + (i + 1) + ".");
        }

        // Add 3 valid comments to post2
        for (int i = 0; i < 3; i++) {
            post2.addComment("This is another comment number " + (i + 1) + ".");
        }

        assertFalse(post1.addComment("This comment should fail because the maximum number of comments has been reached."));
        assertFalse(post2.addComment("This comment should also fail because the maximum number of comments has been reached."));
    }

    // Add more tests for other conditions...
}


