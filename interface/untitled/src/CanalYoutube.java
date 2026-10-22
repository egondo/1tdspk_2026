import java.util.ArrayList;
import java.util.List;

public class CanalYoutube extends Subject implements Observer {

    private String nome;
    private List<String> videos;

    public CanalYoutube(String nome) {
        this.nome = nome;
        this.videos = new ArrayList<>();
    }

    public void addVideo(String titulo) {
        videos.add(titulo);
        this.notification();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    @Override
    public void notification(Subject subject) {
        System.out.println("Novo video cadastrado em " + subject.toString() + " " + nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
