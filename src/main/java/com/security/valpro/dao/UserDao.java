package com.security.valpro.dao;

import com.security.valpro.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface UserDao extends JpaRepository<SysUser,Integer>, PagingAndSortingRepository<SysUser,Integer>, JpaSpecificationExecutor<SysUser> {

    SysUser findByUsername(String name);

    @Query(value="select count(*) from sys_user where MOBILE=:mobile",nativeQuery = true)
    int findByMobile(@Param("mobile")String mobile);

    @Query(value= "select count(*) from sys_user where username=:username",nativeQuery = true)
    int findUsernameExist(@Param("username")String username);
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
