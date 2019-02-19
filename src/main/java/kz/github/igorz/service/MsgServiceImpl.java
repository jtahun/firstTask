package kz.github.igorz.service;

import kz.github.igorz.mappers.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by Jtahun on 16.02.2019.
 */
@Service("msgservice")
public class MsgServiceImpl implements MsgService {

    @Autowired
    MsgMapper msgMapper;

    @Override
    public String getMessage(int id) { return msgMapper.getMessage(1);}
}
