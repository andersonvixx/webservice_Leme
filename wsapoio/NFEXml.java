package cadastros.nfe;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cadastros.Princ;

@XmlRootElement(name="notafiscal")
@XmlType ( propOrder = { "cnpj_cpf_prestador","pessoa_prestador","ie_prestador","im_prestador","razao_social_prestador","endereco_prestador","numero_ende_prestador","" + 
		"complemento_ende_prestador","bairro_prestador","cep_prestador","cidade_prestador","uf_prestador","email_prestador","exterior_dest","cnpj_cpf_destinatario","" + 
		"pessoa_destinatario","ie_destinatario","im_destinatario","razao_social_destinatario","endereco_destinatario","numero_ende_destinatario","" + 
		"complemento_ende_destinatario","bairro_destinatario","cep_destinatario","cidade_destinatario","uf_destinatario","" + 
		"pais_destinatario","fone_destinatario","email_destinatario","numero_nf","serie","valor_nf","deducao","valor_servico","data_emissao","forma_de_pagamento","" +
		"descricao","id_codigo_servico","regime","cancelada","iss_retido","aliq_iss","valor_iss","bc_pis","aliq_pis","valor_pis","bc_cofins","aliq_cofins","valor_cofins","" +
		"bc_csll","aliq_csll","valor_csll","bc_irrf","aliq_irrf","valor_irrf","bc_inss","aliq_inss","valor_inss","nf_avulsa","sistema_gerador","serie_rps","rps",
		"codigo","data_canc","motivo_canc" } )

@XmlAccessorType( XmlAccessType.PUBLIC_MEMBER )
public class NFEXml implements Serializable {
	
	private static final long serialVersionUID = 3L;
	
	private String cnpj_cpf_prestador;
	private String pessoa_prestador;
	private String ie_prestador;
	private String im_prestador;
	private String razao_social_prestador;
	private String endereco_prestador;
	private String numero_ende_prestador;
	private String complemento_ende_prestador;
	private String bairro_prestador;
	private String cep_prestador;
    private String cidade_prestador;
    private String uf_prestador; 
    private String email_prestador;

	//Dados do destinatario
    private String exterior_dest;
	private String cnpj_cpf_destinatario;
	private String pessoa_destinatario;
	private String ie_destinatario;
	private String im_destinatario;
	private String razao_social_destinatario;
	private String endereco_destinatario;
	private String numero_ende_destinatario;
	private String complemento_ende_destinatario;
	private String bairro_destinatario;
	private String cep_destinatario;
	private String cidade_destinatario;
	private String uf_destinatario;
	private String pais_destinatario;
	private String fone_destinatario; 
	private String email_destinatario;
	//Dados da NFES
	private int numero_nf;
	private String serie;
	private String valor_nf;
	private String deducao;
	private String valor_servico;
	private String data_emissao;
	private String forma_de_pagamento;
	private String descricao;
	private String id_codigo_servico;
	private String regime;
	private String cancelada;
	private String iss_retido;
	private String aliq_iss;
	private String valor_iss;
	private String bc_pis;
	private String aliq_pis;
	private String valor_pis;
	private String bc_cofins;
	private String aliq_cofins;
	private String valor_cofins;
	private String bc_csll;
	private String aliq_csll;
	private String valor_csll;
	private String bc_irrf;
	private String aliq_irrf;
	private String valor_irrf;
	private String bc_inss;
	private String aliq_inss;
	private String valor_inss;
	private String nf_avulsa;
	private String sistema_gerador;
	private String serie_rps;
	private String rps;
	private String codigo;
	private String data_canc;
	private String motivo_canc;
	
    public NFEXml() {
		super();
	}
    
	public void recebertNFEXml(String cnpj_cpf_prestador, String pessoa_prestador, String ie_prestador, String im_prestador,
			String razao_social_prestador, String endereco_prestador, String numero_ende_prestador,
			String complemento_ende_prestador, String bairro_prestador, String cep_prestador, String cidade_prestador,
			String uf_prestador, String email_prestador, String exterior_dest, String cnpj_cpf_destinatario,
			String pessoa_destinatario, String ie_destinatario, String im_destinatario,
			String razao_social_destinatario, String endereco_destinatario, String numero_ende_destinatario,
			String complemento_ende_destinatario, String bairro_destinatario, String cep_destinatario,
			String cidade_destinatario, String uf_destinatario, String pais_destinatario, String fone_destinatario,
			String email_destinatario, int numero_nf, String serie, String valor_nf, String deducao,
			String valor_servico, String data_emissao, String forma_de_pagamento, String descricao,
			String id_codigo_servico, String regime, String cancelada, String iss_retido, String aliq_iss,
			String valor_iss, String bc_pis, String aliq_pis, String valor_pis, String bc_cofins, String aliq_cofins,
			String valor_cofins, String bc_csll, String aliq_csll, String valor_csll, String bc_irrf, String aliq_irrf,
			String valor_irrf, String bc_inss, String aliq_inss, String valor_inss, String nf_avulsa,
			String sistema_gerador, String serie_rps, String rps, String codigo) {

		this.cnpj_cpf_prestador = cnpj_cpf_prestador;
		this.pessoa_prestador = pessoa_prestador;
		this.ie_prestador = ie_prestador;
		this.im_prestador = im_prestador;
		this.razao_social_prestador = razao_social_prestador;
		this.endereco_prestador = endereco_prestador;
		this.numero_ende_prestador = numero_ende_prestador;
		this.complemento_ende_prestador = complemento_ende_prestador;
		this.bairro_prestador = bairro_prestador;
		this.cep_prestador = cep_prestador;
		this.cidade_prestador = cidade_prestador;
		this.uf_prestador = uf_prestador.trim();
		this.email_prestador = email_prestador;
		this.exterior_dest = exterior_dest;
		this.cnpj_cpf_destinatario = cnpj_cpf_destinatario.equals( "00000000000" ) || cnpj_cpf_destinatario.equals( "00000000000000" ) ? "0" : cnpj_cpf_destinatario;
		this.pessoa_destinatario = pessoa_destinatario;
		this.ie_destinatario = ie_destinatario;
		this.im_destinatario = im_destinatario;
		this.razao_social_destinatario = razao_social_destinatario;
		this.endereco_destinatario = endereco_destinatario;
		this.numero_ende_destinatario = numero_ende_destinatario;
		this.complemento_ende_destinatario = complemento_ende_destinatario;
		this.bairro_destinatario = bairro_destinatario;
		this.cep_destinatario = cep_destinatario;
		this.cidade_destinatario = cidade_destinatario;
		this.uf_destinatario = uf_destinatario;
		this.pais_destinatario = pais_destinatario;
		this.fone_destinatario = fone_destinatario;
		this.email_destinatario = email_destinatario;
		this.numero_nf = numero_nf;
		this.serie = serie;
		this.valor_nf = valor_nf;
		this.deducao = deducao;
		this.valor_servico = valor_servico;
		this.data_emissao = data_emissao;
		this.forma_de_pagamento = forma_de_pagamento;
		this.descricao = descricao;
		this.id_codigo_servico = id_codigo_servico;
		this.regime = regime;
		this.cancelada = cancelada;
		this.iss_retido = iss_retido;
		this.aliq_iss = aliq_iss;
		this.valor_iss = valor_iss;
		this.bc_pis = bc_pis == null ? "0,00" : bc_pis;
		this.aliq_pis = aliq_pis == null ? "0,00" : aliq_pis;
		this.valor_pis = valor_pis == null ? "0,00" : valor_pis;
		this.bc_cofins = bc_cofins == null ? "0,00" : bc_cofins;
		this.aliq_cofins = aliq_cofins == null ? "0,00" : aliq_cofins;
		this.valor_cofins = valor_cofins == null ? "0,00" : valor_cofins;
		this.bc_csll = bc_csll == null ? "0,00" : bc_csll;
		this.aliq_csll = aliq_csll == null ? "0,00" : aliq_csll;
		this.valor_csll = valor_csll == null ? "0,00" : valor_csll;
		this.bc_irrf = bc_irrf == null ? "0,00" : bc_irrf;
		this.aliq_irrf = aliq_irrf == null ? "0,00" : aliq_irrf;
		this.valor_irrf = valor_irrf == null ? "0,00" : valor_irrf;
		this.bc_inss = bc_inss == null ? "0,00" : bc_inss;
		this.aliq_inss = aliq_inss == null ? "0,00" : aliq_inss;
		this.valor_inss = valor_inss == null ? "0,00" : valor_inss;
		this.nf_avulsa = nf_avulsa;
		this.sistema_gerador = sistema_gerador;
		this.serie_rps = serie_rps;
		this.rps = rps;
		this.codigo = codigo;
	}

	public void recebertNFEXml(String cnpj_cpf_prestador, String pessoa_prestador, String ie_prestador, String im_prestador,
			String razao_social_prestador, String endereco_prestador, String numero_ende_prestador,
			String complemento_ende_prestador, String bairro_prestador, String cep_prestador, String cidade_prestador,
			String uf_prestador, String email_prestador, String exterior_dest, String cnpj_cpf_destinatario,
			String pessoa_destinatario, String ie_destinatario, String im_destinatario,
			String razao_social_destinatario, String endereco_destinatario, String numero_ende_destinatario,
			String complemento_ende_destinatario, String bairro_destinatario, String cep_destinatario,
			String cidade_destinatario, String uf_destinatario, String pais_destinatario, String fone_destinatario,
			String email_destinatario, int numero_nf, String serie, String valor_nf, String deducao,
			String valor_servico, String data_emissao, String forma_de_pagamento, String descricao,
			String id_codigo_servico, String regime, String cancelada, String iss_retido, String aliq_iss,
			String valor_iss, String bc_pis, String aliq_pis, String valor_pis, String bc_cofins, String aliq_cofins,
			String valor_cofins, String bc_csll, String aliq_csll, String valor_csll, String bc_irrf, String aliq_irrf,
			String valor_irrf, String bc_inss, String aliq_inss, String valor_inss, String nf_avulsa,
			String sistema_gerador, String serie_rps, String rps, String codigo, String data_canc, String motivo_canc) {

		this.cnpj_cpf_prestador = cnpj_cpf_prestador;
		this.pessoa_prestador = pessoa_prestador;
		this.ie_prestador = ie_prestador;
		this.im_prestador = im_prestador;
		this.razao_social_prestador = razao_social_prestador;
		this.endereco_prestador = endereco_prestador;
		this.numero_ende_prestador = numero_ende_prestador;
		this.complemento_ende_prestador = complemento_ende_prestador;
		this.bairro_prestador = bairro_prestador;
		this.cep_prestador = cep_prestador;
		this.cidade_prestador = cidade_prestador;
		this.uf_prestador = uf_prestador.trim();
		this.email_prestador = email_prestador;
		this.exterior_dest = exterior_dest;
		this.cnpj_cpf_destinatario = cnpj_cpf_destinatario;
		this.pessoa_destinatario = pessoa_destinatario;
		this.ie_destinatario = ie_destinatario;
		this.im_destinatario = im_destinatario;
		this.razao_social_destinatario = razao_social_destinatario;
		this.endereco_destinatario = endereco_destinatario;
		this.numero_ende_destinatario = numero_ende_destinatario;
		this.complemento_ende_destinatario = complemento_ende_destinatario;
		this.bairro_destinatario = bairro_destinatario;
		this.cep_destinatario = cep_destinatario;
		this.cidade_destinatario = cidade_destinatario;
		this.uf_destinatario = uf_destinatario;
		this.pais_destinatario = pais_destinatario;
		this.fone_destinatario = fone_destinatario;
		this.email_destinatario = email_destinatario;
		this.numero_nf = numero_nf;
		this.serie = serie;
		this.valor_nf = valor_nf;
		this.deducao = deducao;
		this.valor_servico = valor_servico;
		this.data_emissao = data_emissao;
		this.forma_de_pagamento = forma_de_pagamento;
		this.descricao = descricao;
		this.id_codigo_servico = id_codigo_servico;
		this.regime = regime;
		this.cancelada = cancelada;
		this.iss_retido = iss_retido;
		this.aliq_iss = aliq_iss;
		this.valor_iss = valor_iss;
		this.bc_pis = bc_pis == null ? "0,00" : bc_pis;
		this.aliq_pis = aliq_pis == null ? "0,00" : aliq_pis;
		this.valor_pis = valor_pis == null ? "0,00" : valor_pis;
		this.bc_cofins = bc_cofins == null ? "0,00" : bc_cofins;
		this.aliq_cofins = aliq_cofins == null ? "0,00" : aliq_cofins;
		this.valor_cofins = valor_cofins == null ? "0,00" : valor_cofins;
		this.bc_csll = bc_csll == null ? "0,00" : bc_csll;
		this.aliq_csll = aliq_csll == null ? "0,00" : aliq_csll;
		this.valor_csll = valor_csll == null ? "0,00" : valor_csll;
		this.bc_irrf = bc_irrf == null ? "0,00" : bc_irrf;
		this.aliq_irrf = aliq_irrf == null ? "0,00" : aliq_irrf;
		this.valor_irrf = valor_irrf == null ? "0,00" : valor_irrf;
		this.bc_inss = bc_inss == null ? "0,00" : bc_inss;
		this.aliq_inss = aliq_inss == null ? "0,00" : aliq_inss;
		this.valor_inss = valor_inss == null ? "0,00" : valor_inss;
		this.nf_avulsa = nf_avulsa;
		this.sistema_gerador = sistema_gerador;
		this.serie_rps = serie_rps;
		this.rps = rps;
		this.codigo = codigo;
		this.data_canc = data_canc;
		this.motivo_canc = motivo_canc;
		
	}
	

	public String getCnpj_cpf_prestador() {
		return this.cnpj_cpf_prestador;
	}
    
    @XmlElement( name = "cnpj_cpf_prestador" )
	public void setCnpj_cpf_prestador(String cnpj_cpf_prestador) {
		this.cnpj_cpf_prestador = cnpj_cpf_prestador;
	}

	public String getPessoa_prestador() {
		return pessoa_prestador;
	}

	public void setPessoa_prestador(String pessoa_prestador) {
		this.pessoa_prestador = pessoa_prestador;
	}

	public String getIe_prestador() {
		return ie_prestador;
	}

	public void setIe_prestador(String ie_prestador) {
		this.ie_prestador = ie_prestador;
	}

	public String getIm_prestador() {
		return im_prestador;
	}

	public void setIm_prestador(String im_prestador) {
		this.im_prestador = im_prestador;
	}

	public String getRazao_social_prestador() {
		return razao_social_prestador;
	}

	public void setRazao_social_prestador(String razao_social_prestador) {
		this.razao_social_prestador = razao_social_prestador;
	}

	public String getEndereco_prestador() {
		return endereco_prestador;
	}

	public void setEndereco_prestador(String endereco_prestador) {
		this.endereco_prestador = endereco_prestador;
	}

	public String getNumero_ende_prestador() {
		return numero_ende_prestador;
	}

	public void setNumero_ende_prestador(String numero_ende_prestador) {
		this.numero_ende_prestador = numero_ende_prestador;
	}

	public String getComplemento_ende_prestador() {
		return complemento_ende_prestador;
	}

	public void setComplemento_ende_prestador(String complemento_ende_prestador) {
		this.complemento_ende_prestador = complemento_ende_prestador;
	}

	public String getBairro_prestador() {
		return bairro_prestador;
	}

	public void setBairro_prestador(String bairro_prestador) {
		this.bairro_prestador = bairro_prestador;
	}

	public String getCep_prestador() {
		return cep_prestador;
	}

	public void setCep_prestador(String cep_prestador) {
		this.cep_prestador = cep_prestador;
	}

	public String getCidade_prestador() {
		return cidade_prestador;
	}

	public void setCidade_prestador(String cidade_prestador) {
		this.cidade_prestador = cidade_prestador;
	}

	public String getUf_prestador() {
		return uf_prestador;
	}

	public void setUf_prestador(String uf_prestador) {
		this.uf_prestador = uf_prestador;
	}

	public String getEmail_prestador() {
		return email_prestador;
	}

	public void setEmail_prestador(String email_prestador) {
		this.email_prestador = email_prestador;
	}

	public String getExterior_dest() {
		return exterior_dest;
	}

	public void setExterior_dest(String exterior_dest) {
		this.exterior_dest = exterior_dest;
	}

	public String getCnpj_cpf_destinatario() {
		return cnpj_cpf_destinatario;
	}

	public void setCnpj_cpf_destinatario(String cnpj_cpf_destinatario) {
		this.cnpj_cpf_destinatario = cnpj_cpf_destinatario;
	}

	public String getPessoa_destinatario() {
		return pessoa_destinatario;
	}

	public void setPessoa_destinatario(String pessoa_destinatario) {
		this.pessoa_destinatario = pessoa_destinatario;
	}

	public String getIe_destinatario() {
		return ie_destinatario;
	}

	public void setIe_destinatario(String ie_destinatario) {
		this.ie_destinatario = ie_destinatario;
	}

	public String getIm_destinatario() {
		return im_destinatario;
	}

	public void setIm_destinatario(String im_destinatario) {
		this.im_destinatario = im_destinatario;
	}

	public String getRazao_social_destinatario() {
		return razao_social_destinatario;
	}

	public void setRazao_social_destinatario(String razao_social_destinatario) {
		this.razao_social_destinatario = razao_social_destinatario;
	}

	public String getEndereco_destinatario() {
		return endereco_destinatario;
	}

	public void setEndereco_destinatario(String endereco_destinatario) {
		this.endereco_destinatario = endereco_destinatario;
	}

	public String getNumero_ende_destinatario() {
		return numero_ende_destinatario;
	}

	public void setNumero_ende_destinatario(String numero_ende_destinatario) {
		this.numero_ende_destinatario = numero_ende_destinatario;
	}

	public String getComplemento_ende_destinatario() {
		return complemento_ende_destinatario;
	}

	public void setComplemento_ende_destinatario(String complemento_ende_destinatario) {
		this.complemento_ende_destinatario = complemento_ende_destinatario;
	}

	public String getBairro_destinatario() {
		return bairro_destinatario;
	}

	public void setBairro_destinatario(String bairro_destinatario) {
		this.bairro_destinatario = bairro_destinatario;
	}

	public String getCep_destinatario() {
		return cep_destinatario;
	}

	public void setCep_destinatario(String cep_destinatario) {
		this.cep_destinatario = cep_destinatario;
	}

	public String getCidade_destinatario() {
		return cidade_destinatario;
	}

	public void setCidade_destinatario(String cidade_destinatario) {
		this.cidade_destinatario = cidade_destinatario;
	}

	public String getUf_destinatario() {
		return uf_destinatario;
	}

	public void setUf_destinatario(String uf_destinatario) {
		this.uf_destinatario = uf_destinatario;
	}

	public String getPais_destinatario() {
		return pais_destinatario;
	}

	public void setPais_destinatario(String pais_destinatario) {
		this.pais_destinatario = pais_destinatario;
	}

	public String getEmail_destinatario() {
		return email_destinatario;
	}

	public void setEmail_destinatario(String email_destinatario) {
		this.email_destinatario = email_destinatario;
	}

	public int getNumero_nf() {
		return numero_nf;
	}

	public void setNumero_nf(int numero_nf) {
		this.numero_nf = numero_nf;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getValor_nf() {
		return valor_nf
	}

	public void setValor_nf(String valor_nf) {
		this.valor_nf = valor_nf;
	}

	public String getDeducao() {
		return  deducao
	}

	public void setDeducao(String deducao) {
		this.deducao = deducao;
	}

	public String getValor_servico() {
		return  valor_servico
	}

	public void setValor_servico(String valor_servico) {
		this.valor_servico = valor_servico;
	}

	public String getData_emissao() {
		return data_emissao;
	}

	public void setData_emissao(String data_emissao) {
		this.data_emissao = data_emissao;
	}

	public String getForma_de_pagamento() {
		return forma_de_pagamento;
	}

	public void setForma_de_pagamento(String forma_de_pagamento) {
		this.forma_de_pagamento = forma_de_pagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getId_codigo_servico() {
		return id_codigo_servico;
	}

	public void setId_codigo_servico(String id_codigo_servico) {
		this.id_codigo_servico = id_codigo_servico;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public String getCancelada() {
		return cancelada;
	}

	public void setCancelada(String cancelada) {
		this.cancelada = cancelada;
	}

	public String getIss_retido() {
		return iss_retido;
	}

	public void setIss_retido(String iss_retido) {
		this.iss_retido = iss_retido;
	}

	public String getAliq_iss() {
		return  aliq_iss
	}

	public void setAliq_iss(String aliq_iss) {
		this.aliq_iss = aliq_iss;
	}

	public String getValor_iss() {
		return  valor_iss
	}

	public void setValor_iss(String valor_iss) {
		this.valor_iss = valor_iss;
	}

	public String getBc_pis() {
		return  bc_pis
	}

	public void setBc_pis(String bc_pis) {
		this.bc_pis = bc_pis;
	}

	public String getAliq_pis() {
		return  aliq_pis
	}

	public void setAliq_pis(String aliq_pis) {
		this.aliq_pis = aliq_pis;
	}

	public String getValor_pis() {
		return  valor_pis
	}

	public void setValor_pis(String valor_pis) {
		this.valor_pis = valor_pis;
	}

	public String getBc_cofins() {
		return  bc_cofins
	}

	public void setBc_cofins(String bc_cofins) {
		this.bc_cofins = bc_cofins;
	}

	public String getAliq_cofins() {
		return  aliq_cofins
	}

	public void setAliq_cofins(String aliq_cofins) {
		this.aliq_cofins = aliq_cofins;
	}

	public String getValor_cofins() {
		return  valor_cofins
	}

	public void setValor_cofins(String valor_cofins) {
		this.valor_cofins = valor_cofins;
	}

	public String getBc_csll() {
		return  bc_csll
	}

	public void setBc_csll(String bc_csll) {
		this.bc_csll = bc_csll;
	}

	public String getAliq_csll() {
		return  aliq_csll
	}

	public void setAliq_csll(String aliq_csll) {
		this.aliq_csll = aliq_csll;
	}

	public String getValor_csll() {
		return  valor_csll
	}

	public void setValor_csll(String valor_csll) {
		this.valor_csll = valor_csll;
	}

	public String getBc_irrf() {
		return  bc_irrf
	}

	public void setBc_irrf(String bc_irrf) {
		this.bc_irrf = bc_irrf;
	}

	public String getAliq_irrf() {
		return  aliq_irrf
	}

	public void setAliq_irrf(String aliq_irrf) {
		this.aliq_irrf = aliq_irrf;
	}

	public String getValor_irrf() {
		return  valor_irrf
	}

	public void setValor_irrf(String valor_irrf) {
		this.valor_irrf = valor_irrf;
	}

	public String getBc_inss() {
		return  bc_inss
	}

	public void setBc_inss(String bc_inss) {
		this.bc_inss = bc_inss;
	}

	public String getAliq_inss() {
		return  aliq_inss
	}

	public void setAliq_inss(String aliq_inss) {
		this.aliq_inss = aliq_inss;
	}

	public String getValor_inss() {
		return  valor_inss
	}

	public void setValor_inss(String valor_inss) {
		this.valor_inss = valor_inss;
	}

	public String getNf_avulsa() {
		return nf_avulsa;
	}

	public void setNf_avulsa(String nf_avulsa) {
		this.nf_avulsa = nf_avulsa;
	}

	public String getSistema_gerador() {
		return sistema_gerador;
	}

	public void setSistema_gerador(String sistema_gerador) {
		this.sistema_gerador = sistema_gerador;
	}

	public String getSerie_rps() {
		return serie_rps;
	}

	public void setSerie_rps(String serie_rps) {
		this.serie_rps = serie_rps;
	}

	public String getRps() {
		return rps;
	}

	public void setRps(String rps) {
		this.rps = rps;
	}

	public String getFone_destinatario() {
		return fone_destinatario;
	}

	public void setFone_destinatario(String fone_destinatario) {
		this.fone_destinatario = fone_destinatario;
	}
	
	public String retiraCaracter(String vlr, char ch) {

		String resultado = "";
		for (int pos = 0; pos < vlr.length(); pos++) {
			if (vlr.charAt(pos) != ch  ) {
				resultado += vlr.charAt(pos);
			}
		}

		return resultado;
	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getData_canc() {
		return data_canc;
	}

	public void setData_canc(String data_canc) {
		this.data_canc = data_canc;
	}

	public String getMotivo_canc() {
		return motivo_canc;
	}

	public void setMotivo_canc(String motivo_canc) {
		this.motivo_canc = motivo_canc;
	}

}
