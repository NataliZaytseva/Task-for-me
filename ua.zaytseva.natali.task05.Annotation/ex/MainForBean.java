import annotationAnalizer.AnnotationAnalyzer;
import bean.JavaBeanCar;

/**
 * Created by Natali on 28.11.2014.
 */
public class MainForBean {

    public static void main(String[] args) {
        JavaBeanCar beanCar = new JavaBeanCar();
        AnnotationAnalyzer analyzer = new AnnotationAnalyzer();
        try {
            analyzer.annotationAnalyzer(beanCar);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
