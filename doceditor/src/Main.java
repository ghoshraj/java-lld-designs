import com.lld.document.persistence.FileStorage;
import com.lld.document.service.DocumentEditor;
import com.lld.document.service.DocumentRenderer;

public class Main {
    public static void main(String[] args) {

        DocumentEditor editor = new DocumentEditor(new FileStorage());

        editor.addText("Hello ");
        editor.addNextLine();
        editor.addText("World!");
        editor.addNextLine();
        editor.addImage("image.png");
        editor.addNextLine();

        DocumentRenderer renderer = new DocumentRenderer();
        String output = renderer.render(editor.getDocument());
        System.out.print(output);

        editor.save();
    }
}