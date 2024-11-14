package com.example.bookshelfapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.bookshelfapp.databinding.ItemBookBinding

class BookAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.bookTitle.text = book.volumeInfo.title
            binding.bookThumbnail.load(
                book.volumeInfo.imageLinks?.thumbnail?.replace("http", "https")
            )
            // Add click listener to the entire item layout
            binding.root.setOnClickListener {
                // Get the book's link (you'll need to add this to your data model)
                val bookLink = book.volumeInfo.infoLink // Assuming you have a 'infoLink' field

                // Open the book's link in a browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(bookLink))
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size
}