/* Generated By:JavaCC: Do not edit this line. AnalizadorSintactico.java */
package controladoras;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalizadorSintactico implements AnalizadorSintacticoConstants {
GenerarJava generar= new GenerarJava();
  public static void main(String[] args) {


        try {
            AnalizadorSintactico parser = new AnalizadorSintactico(new FileReader(args[0]));
            try {
                parser.Start();
            } catch (ParseException ex) {
                Logger.getLogger(AnalizadorSintactico.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnalizadorSintactico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  final public void Start() throws ParseException {
    jj_consume_token(BEGIN);
    E();
    jj_consume_token(END);
  }

  final public void E() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WHILE:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        VARIABLE();
        break;
      case WHILE:
        WHILE();
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void WHILE() throws ParseException {
 String ncondicion;
    jj_consume_token(WHILE);
    jj_consume_token(PARENTESISABIERTO);
    ncondicion = CONDICION();
    jj_consume_token(PARENTESISCERRADO);
    jj_consume_token(DO);
    jj_consume_token(BEGIN);
                                                                                          generar.escribirWhile(ncondicion);
    E();
                                                                                                                                   generar.recibir("\u005cn}\u005cn"); generar.escribir();
    jj_consume_token(END);
  }

  final public String CONDICION() throws ParseException {
 Token n=new Token(); String condicion="";String [] valor1;String [] valor2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BOLEANO:
      n = jj_consume_token(BOLEANO);
      condicion = OTRACONDICION();
                                              {if (true) return (n.image+" "+ condicion);}
      break;
    case NOT:
      jj_consume_token(NOT);
      n = jj_consume_token(IDENTIFICADOR);
      condicion = OTRACONDICION();
                                                                                                                                   {if (true) return ("!"+ n.image+" "+ condicion);}
      break;
    case NUMBER:
    case IDENTIFICADOR:
    case CADENA:
      valor1 = VALOR();
      n = jj_consume_token(OPERADORR);
      valor2 = VALOR();
      condicion = OTRACONDICION();
                                                                                                                                                                                                                                                  {if (true) return valor1[0]+" "+n.image+" "+valor2[0];}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String OTRACONDICION() throws ParseException {
 Token n= new Token();n.image="";String condicion="";
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OPERADORL:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      n = jj_consume_token(OPERADORL);
      condicion = CONDICION();
    }
                                                  if(n.image.equals("and")){{if (true) return " && "+condicion;}} else if(n.image.equals("or"))  {{if (true) return (" || "+condicion);}} else {{if (true) return "";}}
    throw new Error("Missing return statement in function");
  }

  final public void VARIABLE() throws ParseException {
 Token n;String []valores= new String[2];
    n = jj_consume_token(IDENTIFICADOR);
    jj_consume_token(ASIGNACION);
    valores = VALOR();
                                                 generar.escribirDeclaraciones(n,valores);
    E();
  }

  final public String [] VALOR() throws ParseException {
 Token n;String [] valores = new String[2];
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      n = jj_consume_token(IDENTIFICADOR);
                      valores[0]=n.image ; valores[1]=generar.buscarVariable(n.image);{if (true) return valores;}
      break;
    case NUMBER:
      n = jj_consume_token(NUMBER);
                                                                                                                   valores[0]=n.image ; valores[1]="int" ;{if (true) return valores;}
      break;
    case CADENA:
      n = jj_consume_token(CADENA);
                                                                                                                                                                                        valores[0]=n.image ; valores[1]="String" ;{if (true) return valores;}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public AnalizadorSintacticoTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[5];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x820000,0x820000,0x2806080,0x10000,0x2800080,};
   }

  /** Constructor with InputStream. */
  public AnalizadorSintactico(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AnalizadorSintactico(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AnalizadorSintacticoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public AnalizadorSintactico(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public AnalizadorSintactico(AnalizadorSintacticoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(AnalizadorSintacticoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[27];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 5; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 27; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
