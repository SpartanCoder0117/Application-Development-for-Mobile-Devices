package dyhm.proyecto1;

public class ListaEntrada {
    private int idim;
    private String a;
    private String d;
    private int id;
    private String toa;

    public ListaEntrada() {
    }

    public ListaEntrada(int idim, String a, String d, int id, String toa) {
        this.idim = idim;
        this.a = a;
        this.d = d;
        this.id = id;
        this.toa = toa;
    }

    public int getIdim() {
        return idim;
    }

    public void setIdim(int idim) {
        this.idim = idim;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public void setId(int id){ this.id = id; }

    public int getID(){return id;}

    public void setToa(String toa){ this.toa = toa;}

    public String getToa(){ return this.toa;}

    @Override
    public String toString() {
        return "ListaEntrada{" +
                "idim=" + idim +
                ", a='" + a + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
