package jmu.gcy.service;

import jmu.gcy.bean.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
