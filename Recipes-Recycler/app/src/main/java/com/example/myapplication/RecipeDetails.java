package com.example.myapplication;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.LinkedList;
//Hoang Nguyen 24/3/2019
public class RecipeDetails extends AppCompatActivity {
    private final LinkedList<Recipe> recipes = DataProvider.getRecipes();
    private TextView ingredients;
    private TextView directions;
    private TextView detailTitle;
    private ImageView imageView;
    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        position = getIntent().getIntExtra("position",0);

        ingredients = findViewById(R.id.ingredients);
        directions = findViewById(R.id.directions);
        detailTitle = findViewById(R.id.detailTitle);
        imageView = findViewById(R.id.imageView);

        Recipe recipe = recipes.get(position);

        detailTitle.setText(recipe.name);
        ingredients.setText(recipe.ingredients);
        directions.setText(recipe.directions);
        Picasso.get()
                .load(recipe.image)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}
