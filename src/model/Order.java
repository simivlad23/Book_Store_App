package model;

public class Order extends EntityObject{

    private Long idProd;
    private int cantitate;

    public Order(Long idProd, int cantitate) {

        this.idProd = idProd;
        this.cantitate = cantitate;
    }

    public Order() {
    }

    public Long getIdProd() {
        return idProd;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                ", idProd=" + idProd +
                ", cantitate=" + cantitate +
                '}';
    }


    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }


}
