package universitygroups.mironenko.services;

import org.springframework.stereotype.Component;
import universitygroups.mironenko.dto.GroupDto;
import universitygroups.mironenko.models.Groups;

@Component
public class GroupConverter {

    public GroupDto fromGroupsToGroupDto(Groups groups){

        GroupDto groupDto = new GroupDto();
        groupDto.setId(groups.getId());
        groupDto.setNumber(groups.getNumber());
        return groupDto;
    }

    public Groups fromGroupDtoToGroups(GroupDto groupDto){
        Groups groups = new Groups();
        groups.setId(groupDto.getId());
        groups.setNumber(groupDto.getNumber());
        return groups;
    }

}
