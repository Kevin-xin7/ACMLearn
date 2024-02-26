import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test02 {

    static class Cat {
        public Cat(String name) {
            this.name = name;
        }

        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static SimpleDateFormat format = new SimpleDateFormat("yyyyMM");


    public static void main(String[] args) throws ParseException {

        Calendar instance = Calendar.getInstance();
        //演示使用，将获取时间后移
        if(instance.get(Calendar.DAY_OF_MONTH) > 2){
            instance.add(Calendar.MONTH,-1);
        }else {
            instance.add(Calendar.MONTH,-2);
        }

        String dateTime = format.format(instance.getTime());

//        Date currentDate = format.parse("202302");
        Date currentDate = format.parse(dateTime);
        Calendar currentInstance = Calendar.getInstance();
        currentInstance.setTime(currentDate);
        currentInstance.add(Calendar.MONTH,-5);
        currentDate = new Date(currentDate.getTime()+10);

        String startMonth = format.format(currentInstance.getTime());

    }
}

