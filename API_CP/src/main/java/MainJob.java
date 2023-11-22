import org.quartz.*;

public class MainJob implements Job {
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        CalculadorGradoDeConfianza calculadorGradoDeConfianza = new CalculadorGradoDeConfianza();
        calculadorGradoDeConfianza.execute();
    }
}