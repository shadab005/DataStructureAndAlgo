
public class Car extends Vehicle
{
    int id = 100;
    public int getId()
    {
        return(id - 20);
    }
    public static void main(String[] args)
    {
        Vehicle vc = new Car();
        Car car = (Car) vc;
        System.out.print(vc.id + ", " + vc.getId() + ", ");
        System.out.print(car.id + ", " + car.getId());
    }
}



class Vehicle
{
    int id = 120;
    public int getId()
    {
        return id;
    }
}