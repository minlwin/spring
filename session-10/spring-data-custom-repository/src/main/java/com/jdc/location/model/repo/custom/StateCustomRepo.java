package com.jdc.location.model.repo.custom;

import java.util.List;

import org.springframework.lang.Nullable;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.entity.State.Type;

public interface StateCustomRepo {

	List<State> search(@Nullable Type type, @Nullable String region, @Nullable String name);
}
