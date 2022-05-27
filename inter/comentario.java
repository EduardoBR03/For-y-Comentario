package inter;
import symbols.*;

public class comentario extends Stmt {
   Expr expr; Stmt stmt;

   public comentario() { expr = null; }

   public void init(Expr x) {
      expr = x;  
      if( expr.type != Type.Bool ) expr.error("boolean required in while");
   }
   public void gen(int b, int a) {
      after = a;                // save label a
      expr.jumping(0, a);
      int label = newlabel();   // label for stmt
      emitlabel(label); stmt.gen(label, b);
      emit("goto L" + b);
   }
}
