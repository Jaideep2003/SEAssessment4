public class Main {
    public static void main(String[] args) {
        Post post = new Post();
        post.setPostID(1);
        post.setPostTitle("Valid Title for Post");
        post.setPostBody("This is a valid body with more than 250 characters. This body should meet the minimum character requirement. Adding some more text to ensure it exceeds the limit.");
        post.setPostTags(new String[]{"tag1", "tag2"});
        post.setPostType("Difficult");
        post.setPostEmergencyStatus("Highly Needed");

        if (post.addPost()) {
            System.out.println("Post added successfully.");
        } else {
            System.out.println("Failed to add post.");
        }

        if (post.addComment("This is a valid comment.")) {
            System.out.println("Comment added successfully.");
        } else {
            System.out.println("Failed to add comment.");
        }
    }
}
