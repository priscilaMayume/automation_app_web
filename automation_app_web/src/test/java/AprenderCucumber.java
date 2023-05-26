import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumber extends DataConvert {
    @Dado("^que criei o arquivo corretamente$")
    public void queCrieiOArquivoCorretamente() throws Throwable {
        System.out.printf("*************** PASSOU POR AQUI 1  ***************");

    }

    @Quando("^executar$")
    public void executar() throws Throwable {
        System.out.printf("*************** PASSOU POR AQUI 2  ***************");
    }

    @Entao("^a especificacao deve finalizar com sucesso$")
    public void aEspecificacaoDeveFinalizarComSucesso() throws Throwable {
        System.out.printf("*************** PASSOU POR AQUI 3  ***************");

    }

    private int contator = 0;

    @Dado("que o valor do contator é {int}")
    public void queOValorDoContatorÉ(Integer int1) {
        contator = int1;

    }

    @Quando("eu incrementar em {int}")
    public void euIncrementarEm(Integer int1) {
        contator = contator + int1;

    }

    @Entao("o valor do contator sera {int}")
    public void oValorDoContatorSera(Integer int1) {
        System.out.println(int1);
        System.out.println(contator);
//        Assert.assertTrue(int1==contator);
        Assert.assertEquals(int1.intValue(), contator);
    }

    Date entrega = new Date();

    @Dado("que o prazo e dia {string}")
    public void queOPrazoEDia( Date data)  {
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.DAY_OF_MONTH, dia);
//        cal.set(Calendar.MONTH, mes - 1);
//        cal.set(Calendar.YEAR, ano);

        entrega = data;
    }

    @Quando("a entrega atrasar em {int} {string}")
    public void quandoAEntregaAtrasarEmDias(Integer int1, String tempo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        if (tempo.equals("dias")) {
            cal.add(Calendar.DAY_OF_MONTH, int1);
        }
        if (tempo.equals("meses")) {
            cal.add(Calendar.MONTH, int1);
        }
        entrega = cal.getTime();

    }

    @Entao("a entrega sera efetuada em {string}")
    public void aEntregaSeraEfetuadaEm(String data) {
        DateFormat format = new SimpleDateFormat(("dd/MM/yyyy"));
        String dataFRomatada = format.format(entrega);
        Assert.assertEquals(data, dataFRomatada);

    }

    @Quando("a entrega atrasar em {int} meses")
    public void aEntregaAtrasarEmMeses(Integer int1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        cal.add(Calendar.MONTH, int1);
        entrega = cal.getTime();
    }

    @Dado("que o ticket é {string}{int}")
    public void queOTicketÉ(String string, Integer int1) {

    }

    @Dado("que o valor da passagem é R$ {double}")
    public void queOValorDaPassagemÉR$(Double double1) {

    }

    @Dado("que o nome do passageiro é {string}")
    public void queONomeDoPassageiroÉ(String string) {

    }

    @Dado("que o telefone do passageiro é {int}{int}")
    public void queOTelefoneDoPassageiroÉ(Integer int1, Integer int2) {

    }

    @Quando("criar os steps")
    public void criarOsSteps() {

    }

    @Então("o teste vai funcionar")
    public void oTesteVaiFuncionar() {

    }

    @Dado("que o ticket é AB{int}")
    public void queOTicketÉAB(Integer int1) {

    }

    @Dado("que o valor da passagem é R$ {double}{double}")
    public void queOValorDaPassagemÉR$(Double double1, Double double2) {
    }
}