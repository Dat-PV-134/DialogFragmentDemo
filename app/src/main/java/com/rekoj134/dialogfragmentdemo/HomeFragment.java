package com.rekoj134.dialogfragmentdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.rekoj134.dialogfragmentdemo.databinding.HomeFragmentBinding;

public class HomeFragment extends Fragment {

    HomeFragmentBinding binding;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);

        binding.btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.thong_bao)
                        .setMessage("Bạn đang ở Trang chủ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        String[] strings = {"Android", "Kotlin", "IOS", "Flutter"};

        binding.btnSingleDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.lua_chon)
                        .setSingleChoiceItems(strings, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ListView listView = ((AlertDialog) dialogInterface).getListView();
                                Object checkedItem = listView.getAdapter().getItem(listView.getCheckedItemPosition());
                                Toast.makeText(getContext(), checkedItem.toString(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();

                alertDialog.show();
            }
        });

        boolean[] booleans = {true, false, true, false};

        binding.btnMultiDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.lua_chon)
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                StringBuilder str = new StringBuilder();
                                for (int index = 0; index < strings.length; index++) {
                                    if (booleans[index]) str.append(strings[index]).append(" ");
                                }
                                Toast.makeText(getContext(), str.toString(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();

                alertDialog.show();
            }
        });

        binding.btnMenuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu = new PopupMenu(getContext(), view);
                MenuInflater menuInflater = menu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_button, menu.getMenu());

                menu.show();

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        return menuOnClick(menuItem);
                    }
                });
            }
        });

        return binding.getRoot();
    }

    private boolean menuOnClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nmButtonShow:
                Toast.makeText(getContext(), "Show", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnButtonHide:
                Toast.makeText(getContext(), "Hide", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
