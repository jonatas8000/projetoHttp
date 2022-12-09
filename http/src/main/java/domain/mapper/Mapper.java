package domain.mapper;

import java.util.List;

public interface Mapper <Entity,DTO> {

	public Entity toEntity(DTO dto);
	
	public DTO toDTO(Entity entity);
	
	public List<Entity> toEntity(List<DTO> listDTO);
	
	public List<DTO> toDTO(List<Entity> listEntity);

}
