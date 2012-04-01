

import java.io.Serializable;
import javax.persistence.*;

import com.openappengine.model.product.ProdProduct;


/**
 * The persistent class for the fms_fleet_task_user database table.
 * 
 */
@Entity
@Table(name="fms_fleet_task_user")
public class FmsFleetTaskUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FTU_FLEET_TASK_USER_ID")
	private int ftuFleetTaskUserId;

	@Column(name="FTU_FLEET_USER_ID")
	private int ftuFleetUserId;

	//bi-directional many-to-one association to FmsFleetTask
    @ManyToOne
	@JoinColumn(name="FTU_FLEET_TASK_ID")
	private FmsFleetTask fmsFleetTask;

	//bi-directional many-to-one association to ProdProduct
    @ManyToOne
	@JoinColumn(name="FTU_FLEET_SERVICE_ID")
	private ProdProduct prodProduct;

    public FmsFleetTaskUser() {
    }

	public int getFtuFleetTaskUserId() {
		return this.ftuFleetTaskUserId;
	}

	public void setFtuFleetTaskUserId(int ftuFleetTaskUserId) {
		this.ftuFleetTaskUserId = ftuFleetTaskUserId;
	}

	public int getFtuFleetUserId() {
		return this.ftuFleetUserId;
	}

	public void setFtuFleetUserId(int ftuFleetUserId) {
		this.ftuFleetUserId = ftuFleetUserId;
	}

	public FmsFleetTask getFmsFleetTask() {
		return this.fmsFleetTask;
	}

	public void setFmsFleetTask(FmsFleetTask fmsFleetTask) {
		this.fmsFleetTask = fmsFleetTask;
	}
	
	public ProdProduct getProdProduct() {
		return this.prodProduct;
	}

	public void setProdProduct(ProdProduct prodProduct) {
		this.prodProduct = prodProduct;
	}
	
}