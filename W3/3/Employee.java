interface Sortable {
    public abstract int compare(Sortable b);

    public static void shell_sort(Sortable[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j].compare(a[j + 1]) > 0) {
                    Sortable temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}


class Employee implements Sortable {
    private String name;
    private double salary;
    private int hireday;
    private int hiremonth;
    private int hireyear;

    public Employee(String n, double s, int day, int month, int year) {
        name = n;
        salary = s;
        hireday = day;
        hiremonth = month;
        hireyear = year;
    }

    public void print() {
        System.out.println(name + " " + salary + " " + hireYear());
    }

    public void raiseSalary(double byPercent) {
        salary *= 1 + byPercent / 100;
    }

    public int hireYear() {
        return hireyear;
    }

    @Override
    public int compare(Sortable b) {
        Employee eb = (Employee) b;
        if (hireyear < eb.hireyear) return -1;
        if (hireyear > eb.hireyear) return 1;
        return 0;
    }
}
