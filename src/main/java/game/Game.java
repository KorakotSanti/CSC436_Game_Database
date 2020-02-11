package game;
import java.nio.*;
import javax.swing.*;
import static com.jogamp.opengl.GL4.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.common.nio.Buffers;
/**
 * This is only an example of opengl I found online
 */

public class Game extends JFrame implements GLEventListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private GLCanvas myCanvas;
    private int rendering_program;
    private int vao[] = new int[1];
    public Game() {
        this.setTitle("Chapter2 - program1");
        this.setSize(600,400);
        this.setLocation(200,200);
        myCanvas = new GLCanvas();
        myCanvas.addGLEventListener(this);
        this.add(myCanvas);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub
        GL4 gl = (GL4) GLContext.getCurrentGL();
        gl.glUseProgram(rendering_program);
        gl.glPointSize(100.0f);
        gl.glDrawArrays(GL_POINTS,0,1);
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub
        GL4 gl = (GL4) GLContext.getCurrentGL();
        rendering_program = createShaderProgram();
        gl.glGenVertexArrays(vao.length,vao,0);
        gl.glBindVertexArray(vao[0]);
    }

    private int createShaderProgram(){
        GL4 gl = (GL4) GLContext.getCurrentGL();

        String vshaderSource[] = 
        {
            "#version 430 \n",
            "void main(void) \n",
            "{ gl_Position = vec4(0.0, 0.0, 0.0, 1.0); } \n",
        };

        String fshaderSource[] =
        {
            "#version 430 \n",
            "out vec4 color; \n",
            "void main(void) \n",
            "{ color = vec4(0.0, 0.0, 1.0, 1.0); } \n",
        };

        int vShader = gl.glCreateShader(GL_VERTEX_SHADER);
        gl.glShaderSource(vShader, 3, vshaderSource, null, 0);
        gl.glCompileShader(vShader);

        int fShader = gl.glCreateShader(GL_FRAGMENT_SHADER);
        gl.glShaderSource(fShader, 4, fshaderSource, null, 0);
        gl.glCompileShader(fShader);

        int vfprogram = gl.glCreateProgram();
        gl.glAttachShader(vfprogram, vShader);
        gl.glAttachShader(vfprogram, fShader);
        gl.glLinkProgram(vfprogram);

        gl.glDeleteShader(vShader);
        gl.glDeleteShader(fShader);
        return vfprogram;
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        // TODO Auto-generated method stub

    }
}