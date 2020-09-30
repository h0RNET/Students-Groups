package universitygroups.mironenko.services;

import universitygroups.mironenko.dto.GroupDto;

import java.util.List;


//интерфейс, который задает методы для обработки данных
public interface GroupsServices {
    List<GroupDto> getGroupList();
    GroupDto newGroup(GroupDto groupDto);
    GroupDto getSingleGroup(int idGroup);
}
