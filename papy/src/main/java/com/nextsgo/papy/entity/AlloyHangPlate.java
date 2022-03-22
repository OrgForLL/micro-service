package com.nextsgo.papy.entity;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import com.nextsgo.papy.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 五金挂镀
 * @author min
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
/* @DynamicInsert属性:设置为true,设置为true,表示insert对象的时候,生成动态的insert语句,如果这个字段的值是null就不会加入到insert语句当中.默认false。
@DynamicUpdate属性:设置为true,设置为true,表示update对象的时候,生成动态的update语句,如果这个字段的值是null就不会被加入到update语句中,默认false。
 */
@DynamicInsert
@DynamicUpdate
@Table(name="alloy_hang_plate")
public class AlloyHangPlate extends BaseEntity{	
	
	@NotNull(message = "客户必传")
	@Column(name = "customer_id", nullable=false, columnDefinition=" varchar(36) default ''  comment'客户id'")
	private String customerId;
	
	@NotNull(message = "品名必传")
	@Column(name = "product", nullable=false, columnDefinition=" varchar(500) default ''  comment '品名'")
	private String product;
	
	@Column(name = "colour", nullable=false, columnDefinition="varchar(50) default ''   comment'颜色'")
	private String colour;
	
	@Column(name = "weight", nullable=false, columnDefinition="decimal(12,2) default 0   comment'重量'")
	private BigDecimal weight;
	
	@Column(name = "quantity", nullable=false, columnDefinition=" decimal(12,2) default 0   comment '每斤个数' ")
	private BigDecimal quantity;
	
	@Column(name = "number", nullable=false, columnDefinition="varchar(50) default ''  comment'单据号'")
	private String number;
	
	@Column(name = "price", nullable=false, columnDefinition=" decimal(12,2) default 0   comment '单价' ")
	private BigDecimal price;	
	
	@Column(name = "after_finish", nullable=false, columnDefinition="varchar(50) default ''  comment'后道'")
	private String afterfinish;
	
	@Column(name = "after_quantity", nullable=false, columnDefinition=" decimal(12,2) default 0    comment '后道个数' ")
	private BigDecimal afterQuantity;	
	
	@Column(name = "after_price", nullable=false, columnDefinition=" decimal(12,2) default 0    comment '后道单价' ")
	private BigDecimal afterPrice;	
	
	@Column(name = "remark",  nullable=false, columnDefinition = " varchar(500) default ''    comment '备注'")
	private String remark;

}
