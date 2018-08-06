package entity;

/**
 * Created by MSI on 2018/8/3.
 */
public class Img {
    private String src;
    private int id;
    private String title;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Img{" +
                "src='" + src + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
