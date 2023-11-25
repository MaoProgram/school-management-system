package Domain.Entity;

public enum Status {
    Inactivo(1),
    Matriculado(2),
    Graduado(3);
    private  int statusValue;

    private Status(int statusValue) {
        this.statusValue = statusValue;
    }

    @Override
    public String toString() {
        return name();
        }
}
