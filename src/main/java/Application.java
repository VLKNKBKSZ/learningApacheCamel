import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Application {
    public static void main(String[] args)  throws Exception{
        CamelContext camelContext = new DefaultCamelContext();
        RouteBuilder routeBuilder = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:/home/ubuntu/IdeaProjects/learnApacheCamel/inbox?noop=true").to("file:/home/ubuntu/IdeaProjects/learnApacheCamel/outbox/");
            }
        };
        camelContext.addRoutes(routeBuilder);
        camelContext.start();

        Thread.sleep(10000);
        camelContext.stop();
    }
}
