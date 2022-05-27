package inter;
import symbols.*;

public class For extends Stmt {
   Expr expr,expr2,expr3,expr4,expr5; Stmt stmt;

   public For() { expr = null; stmt = null; }

   public void init(Expr m, Expr n ,Expr o ,Expr p ,Expr q, Stmt s) {
      expr = m;  expr2 = n;expr3 = o; expr4 = p; expr5 = q; stmt = s;
      if( expr.type != Type.Int ) expr.error("integer required in while");
      if( expr2.type != Type.Int ) expr.error("integer required in while");
      if( expr3.type != Type.Bool ) expr.error("boolean required in while");
      if( expr4.type != Type.Int ) expr.error("integer required in while");
      if( expr5.type != Type.Int ) expr.error("integer required in while");
   }
   public void gen(int b, int a) {
      after = a;                // save label a
      expr.jumping(0, a);
      int label = newlabel();   // label for stmt
      emitlabel(label); stmt.gen(label, b);
      emit("goto L" + b);
   }
}