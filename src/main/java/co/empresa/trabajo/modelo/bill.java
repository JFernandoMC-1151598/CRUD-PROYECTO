package co.empresa.trabajo.modelo;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class bill implements Serializable {

	private Integer id;

	private Date date_bill;

	private Integer user_id;

	private boolean value;
	
	private Integer type;
	
	private String observation;

	
}
