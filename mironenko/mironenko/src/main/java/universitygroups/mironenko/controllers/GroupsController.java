package universitygroups.mironenko.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import universitygroups.mironenko.dto.GroupDto;
import universitygroups.mironenko.services.GroupsServices;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/groups")
@AllArgsConstructor
@Log
public class GroupsController {

    private final GroupsServices groupsServices;

    @GetMapping("/groupList")
    public String getJoinInformation(Model model) {
        List<GroupDto> groupDtoList = groupsServices.getGroupList();
        model.addAttribute("groupsList", groupDtoList);
        return "groups";
    }

    @ModelAttribute("group")
    public GroupDto groupDto() {
        return new GroupDto();
    }


    @PostMapping("/saveGroup")
    public String newGroup(@ModelAttribute("group") GroupDto groupDto) {
        GroupDto newGroup = groupsServices.newGroup(groupDto);
        if (newGroup != null) {
            return "redirect:/students/studentsList/" + newGroup.getId();
        }
        return "redirect:/groups/groupList";
    }
}
