package com.github.madeoliveira.x_activity.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_anthropometry")
public class Anthropometry  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	@NotNull(message = "Campo obrigatório!")
	private Double tricepsFold;
	@NotNull(message = "Campo obrigatório!")
	private Double bicipitalFold;
	@NotNull(message = "Campo obrigatório!")
	private Double abdminalFold;
	@NotNull(message = "Campo obrigatório!")
	private Double subscapularFold;
	@NotNull(message = "Campo obrigatório!")
	private Double middleAxillaryFold;
	@NotNull(message = "Campo obrigatório!")
	private Double thighFold;
	@NotNull(message = "Campo obrigatório!")
	private Double thoracicFold;
	@NotNull(message = "Campo obrigatório!")
	private Double suprailacFold;
	@NotNull(message = "Campo obrigatório!")
	private Double calfFold;
	@NotNull(message = "Campo obrigatório!")
	private Double neckCircumf;
	@NotNull(message = "Campo obrigatório!")
	private Double waistCircumf;
	@NotNull(message = "Campo obrigatório!")
	private Double hipCircumf;
	@NotNull(message = "Campo obrigatório!")
	private Double abdomenCircumf;
	@NotNull(message = "Campo obrigatório!")
	private Double RelaxedArmCircumf;
	@NotNull(message = "Campo obrigatório!")
	private Double thighmedialCircumf;
	@NotNull(message = "Campo obrigatório!")
	private Double calfCircumf;
	@NotNull(message = "Campo obrigatório!")
	private Double handleDiameter;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	public Anthropometry(){
	}

	public Anthropometry(Long id, Instant moment, Double tricepsFold, Double bicipitalFold, Double abdminalFold, Double subscapularFold,
			Double middleAxillaryFold, Double thighFold, Double thoracicFold, Double suprailacFold, Double calfFold,
			Double neckCircumf, Double waistCircumf, Double hipCircumf, Double abdomenCircumf, Double relaxedArmCircumf,
			Double thighmedialCircumf, Double calfCircumf, Double handleDiameter, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.tricepsFold = tricepsFold;
		this.bicipitalFold = bicipitalFold;
		this.abdminalFold = abdminalFold;
		this.subscapularFold = subscapularFold;
		this.middleAxillaryFold = middleAxillaryFold;
		this.thighFold = thighFold;
		this.thoracicFold = thoracicFold;
		this.suprailacFold = suprailacFold;
		this.calfFold = calfFold;
		this.neckCircumf = neckCircumf;
		this.waistCircumf = waistCircumf;
		this.hipCircumf = hipCircumf;
		this.abdomenCircumf = abdomenCircumf;
		this.RelaxedArmCircumf = relaxedArmCircumf;
		this.thighmedialCircumf = thighmedialCircumf;
		this.calfCircumf = calfCircumf;
		this.handleDiameter = handleDiameter;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Double getTricepsFold() {
		return tricepsFold;
	}

	public void setTricepsFold(Double tricepsFold) {
		this.tricepsFold = tricepsFold;
	}

	public Double getBicipitalFold() {
		return bicipitalFold;
	}

	public void setBicipitalFold(Double bicipitalFold) {
		this.bicipitalFold = bicipitalFold;
	}

	public Double getAbdminalFold() {
		return abdminalFold;
	}

	public void setAbdminalFold(Double abdminalFold) {
		this.abdminalFold = abdminalFold;
	}

	public Double getSubscapularFold() {
		return subscapularFold;
	}

	public void setSubscapularFold(Double subscapularFold) {
		this.subscapularFold = subscapularFold;
	}

	public Double getMiddleAxillaryFold() {
		return middleAxillaryFold;
	}

	public void setMiddleAxillaryFold(Double middleAxillaryFold) {
		this.middleAxillaryFold = middleAxillaryFold;
	}

	public Double getThighFold() {
		return thighFold;
	}

	public void setThighFold(Double thighFold) {
		this.thighFold = thighFold;
	}

	public Double getThoracicFold() {
		return thoracicFold;
	}

	public void setThoracicFold(Double thoracicFold) {
		this.thoracicFold = thoracicFold;
	}

	public Double getSuprailacFold() {
		return suprailacFold;
	}

	public void setSuprailacFold(Double suprailacFold) {
		this.suprailacFold = suprailacFold;
	}

	public Double getCalfFold() {
		return calfFold;
	}

	public void setCalfFold(Double calfFold) {
		this.calfFold = calfFold;
	}

	public Double getNeckCircumf() {
		return neckCircumf;
	}

	public void setNeckCircumf(Double neckCircumf) {
		this.neckCircumf = neckCircumf;
	}

	public Double getWaistCircumf() {
		return waistCircumf;
	}

	public void setWaistCircumf(Double waistCircumf) {
		this.waistCircumf = waistCircumf;
	}

	public Double getHipCircumf() {
		return hipCircumf;
	}

	public void setHipCircumf(Double hipCircumf) {
		this.hipCircumf = hipCircumf;
	}

	public Double getAbdomenCircumf() {
		return abdomenCircumf;
	}

	public void setAbdomenCircumf(Double abdomenCircumf) {
		this.abdomenCircumf = abdomenCircumf;
	}

	public Double getRelaxedArmCircumf() {
		return RelaxedArmCircumf;
	}

	public void setRelaxedArmCircumf(Double relaxedArmCircumf) {
		RelaxedArmCircumf = relaxedArmCircumf;
	}

	public Double getThighmedialCircumf() {
		return thighmedialCircumf;
	}

	public void setThighmedialCircumf(Double thighmedialCircumf) {
		this.thighmedialCircumf = thighmedialCircumf;
	}

	public Double getCalfCircumf() {
		return calfCircumf;
	}

	public void setCalfCircumf(Double calfCircumf) {
		this.calfCircumf = calfCircumf;
	}

	public Double getHandleDiameter() {
		return handleDiameter;
	}

	public void setHandleDiameter(Double handleDiameter) {
		this.handleDiameter = handleDiameter;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anthropometry other = (Anthropometry) obj;
		return Objects.equals(id, other.id);
	}
	
	
}