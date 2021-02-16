package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PostTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public Post setUpNewPost(){
        return new Post("Day 1: intro");
    }
    @Test
    public void newPostGetsCreatedCorrectly_true() throws Exception {
        Post post = setUpNewPost();
        assertEquals(true, post instanceof Post);
    }

    @Test
    public void postInstiatesWithContent_true() throws Exception{
        Post post = setUpNewPost();
        assertEquals("Day 1: intro", post.getContent());
    }

    @Test
    public void allPostsAreCorrectlyReturned_true() {
        Post newPost = setUpNewPost();
        Post otherPost = new Post("How to learn effectively");
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void postContainsAllPosts_true() {
        Post newPost = setUpNewPost();
        Post otherPost = new Post("How to learn effectively");
        assertTrue(Post.getAll().contains(newPost));
        assertTrue(Post.getAll().contains(otherPost));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() {
        Post newPost = setUpNewPost();
        assertEquals(false, newPost.getPublished());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() {
        Post newPost = setUpNewPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(), newPost.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception{

        Post.clearAll();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!

        Post myPost = new Post("Day 1: Intro");

        assertEquals(1, myPost.getId());
    }
}