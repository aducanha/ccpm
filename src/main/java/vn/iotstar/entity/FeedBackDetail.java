package vn.iotstar.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "[FeedBackDetail]")
public class FeedBackDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "callId")
	private Call call;
	
	@ManyToOne
	@JoinColumn(name = "agentId")
	private Agent agent;
	
	@Column(columnDefinition = "nvarchar(255)")
	private String feedBackContent;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "YYYY-MM-DD hh:mi:ss")
	private Date createAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "YYYY-MM-DD hh:mi:ss")
	private Date updateAt;
	
	//mapping to CallDetail
	@OneToOne(mappedBy = "feedBackDetail")
	private CallDetail callDetail;

}
