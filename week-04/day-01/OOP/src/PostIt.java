import java.awt.*;

public class PostIt {
  Color backgroundColor;
  Color textColor;
  String text;

  public PostIt(Color backgroundColor, Color textColor, String text) {
    this.backgroundColor = backgroundColor;
    this.textColor = textColor;
    this.text = text;
  }

  public static void main(String[] args) {
    PostIt firstText = new PostIt(Color.orange, Color.blue, "Idea 1");
    PostIt secondText = new PostIt(Color.pink, Color.black, "Awesome");
    PostIt thirdText = new PostIt(Color.yellow, Color.black, "Superb!");
  }
}
