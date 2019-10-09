package co.worker.threeminutessul.board.model;

import co.worker.threeminutessul.common.model.CommonVO;
import lombok.Data;

@Data
public class FileVO extends CommonVO{
	private int uploaded;
	private String fileName;
	private String url;
	
}
