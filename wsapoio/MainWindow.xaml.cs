using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WsClientSigissweb
{
    /// <summary>
    /// Interação lógica para MainWindow.xam
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            string json = "{ \"login\": \"coloque o CNPJ do prestador\"  , \"senha\":\"hmlgc\"}";
            string login_sistema;

            System.Net.HttpWebRequest webrequest = (System.Net.HttpWebRequest)System.Net.WebRequest.Create("https://wshml.sigissweb.com/rest/login");
            //System.Net.HttpWebRequest webrequest = (System.Net.HttpWebRequest)System.Net.WebRequest.Create("http://localhost:8081/wssigissweb/rest/login");
        
            webrequest.Method = "POST";
            webrequest.ContentType = "application/json; charset=utf-8";

            //Stream stream = webrequest.GetRequestStream();

            using (var streamWriter = new StreamWriter(webrequest.GetRequestStream()))
            {
                streamWriter.Write(json);
                streamWriter.Flush();
            }

            using (System.Net.WebResponse response = webrequest.GetResponse())
            {

                using (StreamReader reader = new StreamReader(response.GetResponseStream()))
                {
                    //VARIAVEL GLOBAL
                    login_sistema = reader.ReadToEnd();
                }

                response.Close();

            }

            //stream.Close();

            string xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>" +
                          "<notafiscal>" +
                              "<cnpj_cpf_prestador>coloque cnpj do prestador</cnpj_cpf_prestador>" +
                              "<exterior_dest>0</exterior_dest>" +
                              "<cnpj_cpf_destinatario>coloque o CNPJ/CPF do tomador</cnpj_cpf_destinatario>" +
                              "<pessoa_destinatario>F</pessoa_destinatario>" +
                              "<ie_destinatario>isento</ie_destinatario>" +
                              "<im_destinatario>isento</im_destinatario>" +
                              "<razao_social_destinatario>TESTE XML</razao_social_destinatario>" +
                              "<endereco_destinatario>R JOÃO BOSCO</endereco_destinatario>" +
                              "<numero_ende_destinatario>1728</numero_ende_destinatario>" +
                              "<complemento_ende_destinatario>CASA 48</complemento_ende_destinatario>" +
                              "<bairro_destinatario>Centro</bairro_destinatario>" +
                              "<cep_destinatario>13000000</cep_destinatario>" +
                              "<cidade_destinatario>Sumaré</cidade_destinatario>" +
                              "<uf_destinatario>SP</uf_destinatario>" +
                              "<pais_destinatario>Brasil</pais_destinatario>" +
                              "<fone_destinatario>(19) 0000-0000</fone_destinatario>" +
                              "<email_destinatario>suporte@sigissweb.com</email_destinatario>" +
                              "<valor_nf>1230,75</valor_nf>" +
                              "<deducao>0,00</deducao>" +
                              "<valor_servico>1230,75</valor_servico>" +
                              "<data_emissao>10/10/2019</data_emissao>" +
                              "<forma_de_pagamento></forma_de_pagamento>" +
                              "<descricao>Coloque a Descrição do serviço aqui</descricao>" +
                              "<id_codigo_servico>10.03</id_codigo_servico>" +
                              "<cancelada>N</cancelada>" +
                              "<iss_retido>N</iss_retido>" +
                              "<aliq_iss>0,00</aliq_iss>" +
                              "<valor_iss>0,00</valor_iss>" +
                              "<bc_pis>0,00</bc_pis>" +
                              "<aliq_pis>0,00</aliq_pis>" +
                              "<valor_pis>0,00</valor_pis>" +
                              "<bc_cofins>0,00</bc_cofins>" +
                              "<aliq_cofins>0,00</aliq_cofins>" +
                              "<valor_cofins>0,00</valor_cofins>" +
                              "<bc_csll>0,00</bc_csll>" +
                              "<aliq_csll>0,00</aliq_csll>" +
                              "<valor_csll>0,00</valor_csll>" +
                              "<bc_irrf>0,00</bc_irrf>" +
                              "<aliq_irrf>0,00</aliq_irrf>" +
                              "<valor_irrf>0,00</valor_irrf>" +
                              "<bc_inss>0,00</bc_inss>" +
                              "<aliq_inss>0,00</aliq_inss>" +
                              "<valor_inss>0,00</valor_inss>" +
                              "<sistema_gerador>Coloque o nome do sistema emissor do RPS</sistema_gerador>" +
                              "<serie_rps>RP</serie_rps>" +
                              "<rps>1</rps>" +
                          "</notafiscal>"; ;

            System.Net.HttpWebRequest webrequest2 = (System.Net.HttpWebRequest)System.Net.WebRequest.Create("https://wshml.sigissweb.com/rest/nfes");
            //System.Net.HttpWebRequest webrequest2 = (System.Net.HttpWebRequest)System.Net.WebRequest.Create("http://localhost:8081/wssigissweb/rest/nfes");
            webrequest2.Headers.Add("AUTHORIZATION", login_sistema);
            webrequest2.Method = "POST";
            webrequest2.ContentType = "application/xml";

             Stream stream2 = webrequest.GetRequestStream();

            using (var streamWriter = new StreamWriter(webrequest2.GetRequestStream())){
                streamWriter.Write(xml);
                streamWriter.Flush();
            }

            try { 

                System.Net.HttpWebResponse response = (System.Net.HttpWebResponse) webrequest2.GetResponse();

                if ( response.StatusCode == System.Net.HttpStatusCode.OK ){

                    using (StreamReader reader = new StreamReader(response.GetResponseStream())){
                    
                        //VARIAVEL GLOBAL
                        string retorno = reader.ReadToEnd();
                        Console.WriteLine( retorno );

                    }

                }else{

                    Console.WriteLine("Ocorreu o seguinte problema", response.StatusDescription);

                }

                response.Close();   

            }catch (System.Net.WebException e){

                Console.WriteLine("\r\nWebException Raised. The following error occurred : {0}", e.Status);

                using ( StreamReader reader = new StreamReader( e.Response.GetResponseStream())){
                    Console.WriteLine(reader.ReadToEndAsync().Result );
                }

            }catch (Exception e){
                Console.WriteLine("\nThe following Exception was raised : {0}", e.Message);
            }

            



        }
    }
}
