// 1- Bibliotecas, imports...

// Biblioteca do JUnit
import static org.junit.jupiter.api.Assertions.assertEquals; // Biblioteca do JUnit para asserções
import org.junit.jupiter.api.AfterEach; // Biblioteca do JUnit para métodos que são executados após cada teste
import org.junit.jupiter.api.BeforeEach; // Biblioteca do JUnit para métodos que são executados antes de cada teste
import org.junit.jupiter.api.Test; // Biblioteca do JUnit para métodos de teste

import org.openqa.selenium.By; // Biblioteca do Selenium para localizar elementos na página
import org.openqa.selenium.WebDriver; // Biblioteca principal do Selenium
// import org.openqa.selenium.WebElement; // import org.openqa.selenium.WebElement; // Biblioteca do Selenium para elementos da página
import org.openqa.selenium.chrome.ChromeDriver; // Biblioteca do ChromeDriver

// 2- Classe 
public class ComprarPassagemTest {

    // 2.1- Atributos
    private WebDriver driver; // Atributo do Selenium WebDriver
    

    // 2.2- Métodos e funções

    // Antes do teste
    @BeforeEach
    public void iniciar() {
        driver = new ChromeDriver(); // Instanciar o objeto do Selenium como ChromeDriver & "Ligar o navegador"
        driver.manage().window().maximize(); // Maximizar a janela do browser
    }

    // Depois do teste
    @AfterEach
    public void finalizar() {
        driver.quit(); // "Desligar o navegador"
    }

    // Teste
    @Test
    public void comprarPassagem() {
        driver.get("https://www.blazedemo.com"); // Acessar o site Blazedemo

        // ==============================================================================================================================

        // // Jeito que o professor ensinou em aula &&
        // // Selecionar o dropdown (Menu suspenso) de origem e destino e clicar no botão Find Flights
        // driver.findElement(By.name("fromPort")).click(); // Clicar no campo de origem
        // {
        //     WebElement dropdown = driver.findElement(By.name("fromPort")); // Selecionar o campo de origem
        //     dropdown.findElement(By.xpath("//option[. = \"São Paolo\"]")).click(); // Selecionar a opção São Paolo e clicar
        // }
        
        // driver.findElement(By.name("toPort")).click(); // Clicar no campo de destino
        // {
        //     WebElement dropdown = driver.findElement(By.name("toPort")); // Selecionar o campo de destino
        //     dropdown.findElement(By.xpath("//option[. = \"New York\"]")).click(); // Selecionar a opção New York e clicar
        // }

        // ==============================================================================================================================

        // // Jeito alternativo de selecionar o destino &&
        // // Selecionar o dropdown (Menu suspenso) de origem e destino e clicar no botão Find Flights
        // {
        //     WebElement dropdown = driver.findElement(By.name("fromPort")); // Selecionar o campo de origem
        //     dropdown.click(); // Clicar no campo de origem
        //     dropdown.findElement(By.xpath("//option[. = \"São Paolo\"]")).click(); // Selecionar a opção New York e clicar
        // }
        
        // {
        //     WebElement dropdown = driver.findElement(By.name("toPort")); // Selecionar o campo de destino
        //     dropdown.click(); // Clicar no campo de destino
        //     dropdown.findElement(By.xpath("//option[. = \"New York\"]")).click(); // Selecionar a opção New York e clicar
        // }

        // ==============================================================================================================================

        // Jeito simplificado &&
        // Selecionar o dropdown (Menu suspenso) de origem e destino e clicar no botão Find Flights
        driver.findElement(By.name("fromPort")).click(); // Clicar no campo de origem
        driver.findElement(By.xpath("//option[. = \"São Paolo\"]")).click(); // Selecionar a opção São Paolo e clicar
        driver.findElement(By.name("toPort")).click(); // Clicar no campo de destino
        driver.findElement(By.xpath("//option[. = \"New York\"]")).click(); // Selecionar a opção New York e clicar
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click(); // Clicar no botão Find Flights
        //Os principais métodos de localização de elementos são: By.id, By.name, By.className, By.tagName, By.xpath, By.cssSelector
     
        // =========== Transição de página ===========
        
        // assertEquals é uma função do JUnit que verifica se o valor esperado é igual ao valor retornado
        assertEquals("Flights from São Paolo to New York:", driver.findElement(By.cssSelector("h3")).getText()); // Verificar se a mensagem apareceu
        driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click(); // Clicar no botão Choose This Flight

        // =========== Transição de página ===========

        // assertEquals é uma função do JUnit que verifica se o valor esperado é igual ao valor retornado
        assertEquals("Your flight from TLV to SFO has been reserved.", driver.findElement(By.cssSelector("h2")).getText()); // Verificar se a mensagem apareceu
        
        driver.findElement(By.id("inputName")).sendKeys("David Medeiros"); // Preencher o campo "Nome"
        driver.findElement(By.id("address")).sendKeys("Test"); // Preencher o campo "Endereço"
        driver.findElement(By.id("city")).sendKeys("Rio de Janeiro"); // Preencher o campo "Cidade"
        driver.findElement(By.id("state")).sendKeys("Rio de Janeiro"); // Preencher o campo "Estado"
        driver.findElement(By.id("zipCode")).sendKeys("11111-222"); // Preencher o campo "Cep"
        driver.findElement(By.id("cardType")).click(); // Clicar no campo "Tipo de cartão"

        driver.findElement(By.xpath("//option[@value='visa']")).click(); // Selecionar a opção Visa
        driver.findElement(By.id("creditCardNumber")).sendKeys("1111.2222.3333.4444"); // Preencher o campo "Número do cartão"
        driver.findElement(By.id("creditCardMonth")).sendKeys("12"); // Preencher o campo "Mês do cartão"
        driver.findElement(By.id("creditCardYear")).sendKeys("2028"); // Preencher o campo "Ano do cartão"
        driver.findElement(By.id("nameOnCard")).sendKeys("David Medeiros"); // Preencher o campo "Nome do cartão"

        driver.findElement(By.id("rememberMe")).click(); // Clicar no campo "Lembrar-me"
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click(); // Clicar no botão Find Flights

        // =========== Transição de página ===========

        assertEquals("Thank you for your purchase today!", driver.findElement(By.cssSelector("h1")).getText()); // Verificar se a mensagem apareceu
    }
}