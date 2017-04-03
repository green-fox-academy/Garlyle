import java.util.ArrayList;

public class Blog {
  ArrayList<BlogPost> blogPosts = new ArrayList<>();

  public void add(BlogPost post)
  {
    blogPosts.add(post);
  }

  public void delete(int index)
  {
    blogPosts.remove(index);
  }

  public void update(int index, BlogPost post)
  {
    delete(index);
    blogPosts.add(index, post);
  }

  public static void main(String[] args) {
    BlogPost firstPost = new BlogPost(
        "John Doe",
        "Lorem Ipsum",
        "Lorem ipsum dolor sit amet.",
        "2000.05.04.");
    BlogPost secondPost = new BlogPost(
        "Tim Urban",
        "Wait but why",
        "A popular long-form, stick-figure-illustrated blog about almost everything.",
        "2010.10.10.");
    BlogPost thirdPost = new BlogPost(
        "William Turton",
        "One Engineer Is Trying to Get IBM to Reckon With Trump",
        "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. " +
            "When I asked to take his picture outside one of IBM’s New York City offices, he told me that " +
            "he wasn’t really into the whole organizer profile thing.",
        "2017.03.28.");

    Blog myBlog = new Blog();

    myBlog.add(firstPost);
    myBlog.add(secondPost);
    myBlog.update(0, thirdPost);

    for (BlogPost post : myBlog.blogPosts)
    {
      System.out.println(post.title);
      System.out.println("posted by " + post.authorName + " on " + post.publicationDate);
      System.out.println(post.text);
      System.out.println();
    }
  }
}
