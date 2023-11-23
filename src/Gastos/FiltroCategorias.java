package Gastos;

public class FiltroCategorias implements Filtrable{
    private String categoriaFiltro;

    public FiltroCategorias(String categoriaFiltro) {
        this.categoriaFiltro = categoriaFiltro;
    }

    @Override
    public Boolean cumpleFiltro (Gastos gastos) {
        return gastos.getCategoria().getName().equalsIgnoreCase(categoriaFiltro);
    }
}
