package br.com.itau.techinsiders.ibank.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Transferencias implements Serializable {

	
	private static final long serialVersionUID = 4923576883315580007L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_origem", referencedColumnName = "id")
	private Correntista origem;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_destino", referencedColumnName = "id")
	private Correntista destino;
	
	@Column(name = "valor", updatable = false)
	private Double valor;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTransferencia;


}
