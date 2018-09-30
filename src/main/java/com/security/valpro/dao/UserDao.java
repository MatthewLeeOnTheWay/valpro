package com.security.valpro.dao;

import com.security.valpro.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends JpaRepository<SysUser,Integer>, PagingAndSortingRepository<SysUser,Integer>, JpaSpecificationExecutor<SysUser> {
    SysUser findByUsername(String name);
    Page<SysUser> findDistinctByPasswordIsNotNull(Pageable pageable);
    /*
    * @RequestMapping(value = "/params", method=RequestMethod.GET)
        public Page<Blog> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "15") Integer size) {
            Sort sort = new Sort(Direction.DESC, "id");
            Pageable pageable = new PageRequest(page, size, sort);
            return blogRepository.findAll(pageable);
        }

        @RequestMapping(value = "", method=RequestMethod.GET)
        public Page<Blog> getEntryByPageable(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC)
            Pageable pageable) {
            return blogRepository.findAll(pageable);
        }
    * */
}
