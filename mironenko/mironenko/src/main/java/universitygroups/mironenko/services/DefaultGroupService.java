package universitygroups.mironenko.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import universitygroups.mironenko.dto.GroupDto;
import universitygroups.mironenko.models.Groups;
import universitygroups.mironenko.repositories.GroupRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
@Log
@Data
//класс, в котором происходит обработка данных
public class DefaultGroupService implements GroupsServices {

    private final GroupRepository groupRepository;
    private final GroupConverter groupConverter;

    @Override
    public List<GroupDto> getGroupList() {
        List<GroupDto> groupDtos = new ArrayList<GroupDto>();
        groupDtos.addAll(groupRepository.getJoinInformation());
        return groupDtos;
    }

    @Override
    public GroupDto newGroup(GroupDto groupDto) {
        Groups savedGroups;
        if (!(groupRepository.existsByNumber(groupDto.getNumber())) && !(groupDto.getNumber().equals(""))) {
            savedGroups = groupRepository.save(groupConverter.fromGroupDtoToGroups(groupDto));
            return groupConverter.fromGroupsToGroupDto(savedGroups);
        } else {
            return null;
        }
    }

    @Override
    public GroupDto getSingleGroup(int idGroup) {
        Groups group = groupRepository.findByid(idGroup);
        return groupConverter.fromGroupsToGroupDto(group);
    }
}
